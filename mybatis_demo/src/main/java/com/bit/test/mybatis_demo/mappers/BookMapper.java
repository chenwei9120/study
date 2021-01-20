package com.bit.test.mybatis_demo.mappers;

import com.bit.test.mybatis_demo.model.Book;

import java.util.List;

public interface    BookMapper {

    Book selectBook(Long id);

    void save(Book book);

    void update(Book book);

    List<Book> findAllBooks(int pageNum, int pageSize);
}
