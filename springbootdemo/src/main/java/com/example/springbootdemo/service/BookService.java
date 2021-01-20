package com.example.springbootdemo.service;

import com.example.springbootdemo.model.ReadBookPd;
import java.util.List;

public interface BookService {

    List<ReadBookPd> selectAllBooks(int pageNum, int pageSize);
}
