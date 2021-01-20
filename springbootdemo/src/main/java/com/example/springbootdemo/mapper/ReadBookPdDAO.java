package com.example.springbootdemo.mapper;

import com.example.springbootdemo.model.ReadBookPd;
import com.example.springbootdemo.model.ReadBookPdExample;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * ReadBookPdDAO继承基类
 */
@Repository
public interface ReadBookPdDAO extends MyBatisBaseDao<ReadBookPd, Integer, ReadBookPdExample> {

    List<ReadBookPd> selectAllBooks(int pageNum, int pageSize);
}