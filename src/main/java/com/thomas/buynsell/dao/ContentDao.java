package com.thomas.buynsell.dao;

import com.thomas.buynsell.meta.Content;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Component;

import java.util.List;

@Component("ContentDao")
public interface ContentDao {

    @Insert("INSERT INTO content (title, price, image, summary, text)" +
            "VALUES (#{0}, #{1}, #{2}, #{3}, #{4})")
    void addContent(String title,
                    double price, String image,
                    String summary, String text);

    @Select("SELECT * FROM content WHERE id=#{0}")
    Content getContentById(int id);

    @Select("SELECT * FROM content WHERE id = (SELECT MAX(id) FROM content)")
    Content getLastContent();

    @Select("SELECT * FROM content")
    List<Content> getContentList();

    @Delete("DELETE FROM content WHERE id = #{0}")
    void deleteContent(int id);

    @Update("UPDATA content SET buyNum=buyNum+#{0}")
    void updataContent(int buyNum);
}
