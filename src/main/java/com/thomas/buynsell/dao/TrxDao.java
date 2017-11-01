package com.thomas.buynsell.dao;

import com.thomas.buynsell.meta.Content;
import com.thomas.buynsell.meta.Transaction;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.math.BigInteger;
import java.util.List;

@Component("TrxDao")
public interface TrxDao {
    @Select("SELECT * FROM trx WHERE personId = #{0}")
    List<Transaction> getTrxListByUserId(int id);

    @Insert("INSERT INTO trx (contentId, personId, price, time, buyNum) VALUES (#{0}, #{1}, #{2}, #{3}, #{4})")
    void addTrx(int contentId, int personId, double price, String time, int buyNum);

    @Select("SELECT content.*, trx.* FROM content INNER JOIN trx on trx.contentId=content.id WHERE trx.personId=#{0}")
    List<Content> getBuyList(int userId);
}
