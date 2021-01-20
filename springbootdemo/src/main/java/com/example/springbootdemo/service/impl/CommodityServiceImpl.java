package com.example.springbootdemo.service.impl;

import com.example.springbootdemo.annotation.Master;
import com.example.springbootdemo.mapper.CommodityMapper;
import com.example.springbootdemo.model.Commodity;
import com.example.springbootdemo.model.CommodityExample;
import com.example.springbootdemo.service.CommodityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;

/**
 * @author chenwei
 * @version 1.0.0
 * @ClassName CommodityServiceImpl.java
 * @Description TODO
 * @createTime 2019年11月06日 15:19:00
 */
@Service
public class CommodityServiceImpl implements CommodityService {
    @Autowired(required = false)
    private CommodityMapper commodityMapper;

    @Transactional
    @Override
    public int insert(Commodity Commodity) {
        return commodityMapper.insert(Commodity);
    }

    @Transactional
    public void batchSave(Commodity[] commodityList) {
//        for(int i = 0; i < commodityList.length; ++i) {//抛出异常，测试事务是否能够正常运行
//            commodityMapper.insert(commodityList[i]);
//            if(i == 1) {
//                throw new RuntimeException("ddddddddd");
//            }
//        }
        Arrays.stream(commodityList).forEach(commodity-> commodityMapper.insert(commodity));
    }

    @Master
    @Override
    public int save(Commodity Commodity) {
        return commodityMapper.insert(Commodity);
    }

    @Override
    public List<Commodity> selectAll() {
        return commodityMapper.selectByExample(new CommodityExample());
    }

    @Master
    @Override
    public String getToken(String appId) {
        //  有些读操作必须读主数据库
        //  比如，获取微信access_token，因为高峰时期主从同步可能延迟
        //  这种情况下就必须强制从主数据读
        return null;
    }

    @Override
    @Transactional(rollbackFor=Exception.class)
    public String execTransaction(Commodity commodity) {
        try {
            commodityMapper.insert(commodity);
            Commodity commodity1 = commodityMapper.selectByPrimaryKey(commodity.getId());
            commodity1.setName(commodity1.getName() + " update1");
            commodityMapper.updateByPrimaryKey(commodity1);
        } catch (Exception e) {
            return e.getMessage();
        }
        return "OK";
    }
}