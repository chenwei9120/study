package com.example.springbootdemo.service.impl;

import com.example.springbootdemo.mapper.ReadBookPdDAO;
import com.example.springbootdemo.model.ReadBookPd;
import com.example.springbootdemo.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    @Autowired(required = false)
    private ReadBookPdDAO readBookPdDAO;

    @Override
    public List<ReadBookPd> selectAllBooks(int pageNum, int pageSize) {
        return readBookPdDAO.selectAllBooks(pageNum, pageSize);
//        List<ReadBookPd> list = new ArrayList<>();
//        list.add(readBookPdDAO.selectByPrimaryKey(1));
//        return list;
    }
}
