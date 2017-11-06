package com.thomas.buynsell.web.controller;


import com.thomas.buynsell.meta.BuyProduct;
import com.thomas.buynsell.meta.Content;
import com.thomas.buynsell.meta.Person;
import com.thomas.buynsell.meta.Transaction;
import com.thomas.buynsell.service.Service;
import com.thomas.buynsell.utils.CookieTool;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

@Controller
public class UserController {
    private static final String USER_DOES_NOT_EXIST = "001";
    private static final String WRONG_PASSWORD = "002";
    private static final String UNLOGIN = "003";

    @Resource
    private Service service;

    @RequestMapping("/*")
    public String index(HttpServletRequest req, ModelMap map) {

        List<Content> pList = service.getContentList();
        map.addAttribute("productList", pList);
        String viewName = prepareUser(req, map, "index");
        System.out.println("productList created");

        return viewName;

    }

    @RequestMapping("/login")
    public String login() {
        return "login";
    }

    @RequestMapping("/logout")
    public String logout(HttpServletResponse res) {
        Cookie cookie = new Cookie("userName", null);
        CookieTool.deleteCookie(res, cookie, "/");
        return "login";
    }

    //用户登录提交处理
    @RequestMapping(value = "/api/login")
    public String loginSubmit(@RequestParam("userName") String userName,
                        @RequestParam("password") String password,
                        HttpSession session,
                        RedirectAttributes reAttributes) throws IOException {
        System.out.println("login..."+userName);
        String loginMsg = "";
        Person person = service.getPersonByName(userName);
        System.out.println(person);
        if (person == null) {
            loginMsg = "redirect:/api/errorInfo";
            reAttributes.addFlashAttribute("error", USER_DOES_NOT_EXIST);
        } else if (!person.getPassword().equals(password)) {
            loginMsg = "redirect:/api/errorInfo";
            reAttributes.addFlashAttribute("error", WRONG_PASSWORD);
        } else {
            loginMsg = "redirect:/api/userInfo";
            session.setAttribute("user", person);

        }
        reAttributes.addFlashAttribute("user", person);
        return loginMsg;
    }


    //返回用户信息，若未登录则返回错误页面
    @RequestMapping(value = "/api/userInfo")
    public void showUserInfo(HttpSession session,
                               HttpServletResponse resp,
                               ModelAndView mav,
                               RedirectAttributes reAttributes) throws IOException {
        System.out.println("userInfo...");
        Person person;
        String jsonStr;
        String viewName = "";
        if (session.getAttribute("user") != null) {
            person = (Person) session.getAttribute("user");
            Cookie cookie = new Cookie("userName", person.getUserName());
            CookieTool.addCookie(resp, cookie, "/");
            System.out.println(person.getClass().getSimpleName());
            viewName = "index";
            mav.addObject("person", person);
            mav.setViewName(viewName);
            session.invalidate();
            jsonStr = "{\"code\":\"200\",\"message\":\"Login Success\",\"result\":\"true\"}";
            System.out.println(jsonStr);
            resp.getWriter().write(jsonStr);
        } else {
            reAttributes.addFlashAttribute("error", UNLOGIN);
        }
    }

    @RequestMapping("/public")
    public String editProduct(HttpServletRequest req, ModelMap map) {
        String viewName = prepareUser(req, map, "public");
        return viewName;
    }

    @RequestMapping("/publicSubmit")
    public String publicSubmit(HttpServletRequest req, ModelMap map,
                               @RequestParam("title") String title,
                               @RequestParam("summary") String summary,
                               @RequestParam("text") String text,
                               @RequestParam("image") String image,
                               @RequestParam("price") double price
                               ) {
        String viewName = prepareUser(req, map, "publicSubmit");
        service.addContent(title, price, image, summary, text);
        map.addAttribute("product", service.getLastContent());
        System.out.println(service.getLastContent());
        return viewName;
    }

    @RequestMapping("/api/delete")
    public void deleteProduct(HttpServletRequest req, ModelMap map,
                                HttpServletResponse resp,
                                @RequestParam("id") int id) throws IOException {
        prepareUser(req, map, null);
        service.deleteContent(id);
        String jsonStr = "{\"code\":\"200\",\"message\":\"OK\",\"result\":\"true\"}";
        resp.getWriter().write(jsonStr);

    }

    @RequestMapping("/show")
    public String showProduct(HttpServletRequest req, ModelMap map,
                              @RequestParam("id") int id) {
        String viewName = prepareUser(req, map, "show");
        Content product = service.getContentById(id);
        map.addAttribute("product", product);
        return viewName;

    }

    @RequestMapping("/settleAccount")
    public String settleAccount(HttpServletRequest req, ModelMap map) {
        String viewName = prepareUser(req, map, "settleAccount");
        return viewName;

    }

    @RequestMapping("/account")
    public String account(HttpServletRequest req, ModelMap map,
                          @RequestParam("id") int id) {
        String viewName = prepareUser(req, map, "account");
        List<Content> buyList = new ArrayList<Content>();
        List<Transaction> trxList = service.getTrxListByUserId(id);
        for (Transaction trx:trxList) {
            System.out.println(trx);
            Content dContent = service.getContentById(trx.getProductId());
            dContent.setBuyNum(trx.getBuyNum());
            dContent.setBuyTime(Long.parseLong(trx.getBuyTime()));
            dContent.setBuyPrice(trx.getBuyNum()*dContent.getPrice());
            buyList.add(dContent);
        }
        map.addAttribute("buyList",buyList);
        return viewName;
    }

    @RequestMapping("/api/buy")
    public void buy(HttpServletRequest req, ModelMap map,
                    HttpServletResponse resp,
                    @RequestBody List<BuyProduct> buyProducts) throws IOException {
        String time = System.currentTimeMillis()+"";
        System.out.println(buyProducts);
        for (BuyProduct bp: buyProducts) {
            Content dContent = service.getContentById(bp.getId());
            System.out.println(dContent.getId());
            service.addTrx(dContent.getId(),0, dContent.getPrice()*bp.getNumber(),time, bp.getNumber());
            System.out.println(dContent.getPrice()*bp.getNumber());
        }
        String jsonStr = "{\"code\":\"200\",\"message\":\"OK\",\"result\":\"true\"}";
        resp.getWriter().write(jsonStr);
    }

    //处理错误信息并返回相应的错误页面
    @RequestMapping(value = "/api/errorInfo")
    public String showErrorInfo(ModelMap map) {
        String error = (String) map.get("error");
        map.addAttribute("error",error);
        return "error";
    }

    String prepareUser(HttpServletRequest req, ModelMap map, String normalView) {
        Cookie cookie = CookieTool.getCookieByName(req, "userName");
        String userName = (cookie != null) ? (cookie.getValue()) : null;
        String viewName;
        if (userName != null) {
            Person person = service.getPersonByName(userName);
            map.addAttribute("person", person);
            viewName = normalView;
        } else {
            viewName = "redirect:/api/errorInfo";
            map.addAttribute("error", UNLOGIN);
            viewName = "redirect:/api/errorInfo";
        }
        return viewName;
    }

}
