package com.example.springbootdemo.mapper;

import com.example.springbootdemo.model.Commodity;
import com.example.springbootdemo.model.CommodityExample;

/**
 * CommodityDAO继承基类
 */
//@Repository
public interface CommodityMapper extends MyBatisBaseDao<Commodity, Integer, CommodityExample> {

    //int insert(Commodity record);
}