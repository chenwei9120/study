package com.example.springbootdemo.service;

import com.example.springbootdemo.model.Commodity;
import java.util.List;

/**
 * @author chenwei
 * @version 1.0.0
 * @ClassName CommodityService.java
 * @Description TODO
 * @createTime 2019年11月06日 15:18:00
 */

public interface CommodityService {

    int insert(Commodity Commodity);

    int save(Commodity commodity);

    List<Commodity> selectAll();

    String getToken(String appId);

    String execTransaction(Commodity commodity);
}