package com.thomas.buynsell.dao;

import com.thomas.buynsell.meta.Person;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;


@Component("UserDao")
public interface UserDao {

    @Select("SELECT * FROM person WHERE userName=#{0}")
    Person getUserByName(String userName);
}
