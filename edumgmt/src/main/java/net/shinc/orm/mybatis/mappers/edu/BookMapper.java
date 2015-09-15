package net.shinc.orm.mybatis.mappers.edu;

import net.shinc.orm.mybatis.bean.edu.Book;

public interface BookMapper {
    Integer deleteByPrimaryKey(Integer id);

    Integer insert(Book book);

    Integer insertSelective(Book book);

    Book selectByPrimaryKey(Integer id);

    Integer updateByPrimaryKeySelective(Book book);

    Integer updateByPrimaryKey(Book book);
}