package com.bit.test.mybatis_demo.controller;

import com.bit.test.mybatis_demo.mappers.BookMapper;
import com.bit.test.mybatis_demo.model.Book;
import com.bit.test.mybatis_demo.service.BookService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.aop.framework.AopContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/book")
public class BookController {

    @Autowired(required = false)
    private BookMapper bookMapper;

    @Autowired
    private BookService bookService;

    @GetMapping("/{id}")
    public Book getBookById(@PathVariable Long id) {
        Book book = bookMapper.selectBook(id);
        return book;
    }

    @GetMapping("/query")
    public PageInfo<Book> getAllBooks(@RequestParam(name = "pageNum", required = false, defaultValue = "1") int pageNum,
                                      @RequestParam(name = "pageSize", required = false, defaultValue = "10") int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<Book> bookList = bookMapper.findAllBooks(pageNum, pageSize);
        PageInfo<Book> pageInfo = new PageInfo<Book>(bookList);
        System.out.println("总条数=" + pageInfo.getTotal());
        return pageInfo;
    }

    @GetMapping("/save")
    public void save() {
        Book book = bookService.createBook();
        bookService.updateBook(book);
    }


}
