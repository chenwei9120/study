package com.example.springbootdemo.controller;


import com.example.springbootdemo.model.ReadBookPd;
import com.example.springbootdemo.service.BookService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/book")
public class BookController {

    @Autowired(required = false)
    private BookService bookService;


    @GetMapping("/query")
    public PageInfo<ReadBookPd> getAllBooks(@RequestParam(name = "pageNum", required = false, defaultValue = "1") int pageNum,
                                      @RequestParam(name = "pageSize", required = false, defaultValue = "10") int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<ReadBookPd> bookList = bookService.selectAllBooks(pageNum, pageSize);
        PageInfo<ReadBookPd> pageInfo = new PageInfo<>(bookList);
        System.out.println("总条数=" + pageInfo.getTotal());
        return pageInfo;
    }

}
