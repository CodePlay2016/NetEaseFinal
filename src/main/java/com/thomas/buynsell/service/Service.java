package com.thomas.buynsell.service;

import com.thomas.buynsell.dao.ContentDao;
import com.thomas.buynsell.dao.TrxDao;
import com.thomas.buynsell.dao.UserDao;
import com.thomas.buynsell.meta.Content;
import com.thomas.buynsell.meta.Person;
import com.thomas.buynsell.meta.Transaction;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.math.BigInteger;
import java.util.List;

@Component
public class Service {
    @Resource(name = "UserDao")
    private UserDao userDao;

    @Resource(name = "ContentDao")
    private ContentDao contentDao;

    @Resource(name = "TrxDao")
    private TrxDao trxDao;

    //-------------person----------------------

    public Person getPersonByName(String userName) {
        return userDao.getUserByName(userName);
    }

    //-------------Content-----------------------

    public Content getContentById(int id) {
        return contentDao.getContentById(id);
    }

    public void addContent(String title,
                           double price, String image,
                           String summary, String text){
        contentDao.addContent(title, price, image, summary, text);
    }

    public List<Content> getContentList() {
        return contentDao.getContentList();
    }

    public Content getLastContent() {
        return contentDao.getLastContent();
    }

    public void deleteContent(int id) {
        contentDao.deleteContent(id);
    }

    public void updataContent(int buyNum) {
        contentDao.updataContent(buyNum);
    }

    //-------------trx-----------------------------

    public List<Transaction> getTrxListByUserId(int id){
        return trxDao.getTrxListByUserId(id);
    }

    public void addTrx(int contentId, int personId, double price, String time, int buyNum){
        trxDao.addTrx(contentId, personId, price, time, buyNum);
    }

//    public void addTrxInstance(Transaction trx) {
//        trxDao.addTrx(trx.getProductId(), trx.getPersonId(), trx.getPrice(), trx.getBuyNum());
//    }

    public List<Content> getBuyList(int userId) {
        return trxDao.getBuyList(userId);
    }
}
