package com.thomas.buynsell.utils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CookieTool {
    public static void addCookie(HttpServletResponse res, Cookie cookie, String path) {
        cookie.setPath(path);
        res.addCookie(cookie);
    }

    public static void deleteCookie(HttpServletResponse res, Cookie cookie, String path) {
        cookie.setPath(path);
        cookie.setMaxAge(0);
        res.addCookie(cookie);
    }

    public static Cookie getCookieByName(HttpServletRequest req, String ckName) {
        Cookie[] cookies=req.getCookies();
        Cookie crt=null;
        if(cookies!=null){
            for(Cookie cookie:cookies){
                if(cookie.getName().equals(ckName)){
                    crt=cookie;
                }
            }
        }
        return crt;
    }
}
