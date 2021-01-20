package com.example.springbootdemo.controller;

import com.example.springbootdemo.model.Commodity;
import com.example.springbootdemo.model.ReadBookPd;
import com.example.springbootdemo.service.impl.CommodityServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;
import java.util.List;

/**
 * @author chenwei
 * @version 1.0.0
 * @ClassName DemoController.java
 * @Description TODO
 * @createTime 2019年11月03日 21:14:00
 */
@RestController
@RequestMapping("/demo")
public class DemoController {

    @Autowired//需要@controller
    private CommodityServiceImpl commodityService;

    @RequestMapping("/")
    @ResponseBody//查询
    public List<Commodity> index() {
        return commodityService.selectAll();
    }

    @RequestMapping("/reqparams")
    public String getRequestParams(HttpServletRequest request) {
        StringBuilder sb = new StringBuilder();
        Enumeration<String> headerNames = request.getHeaderNames();
        while(headerNames.hasMoreElements() ) {
            String element = headerNames.nextElement();
            if(element != null) {
                sb.append(element + ": " + request.getHeader(element) + "</br>");
            }
        }
        return sb.toString();
    }

    @PostMapping("/save")
    public String save(@RequestBody Commodity commodity) {
        //return commodityService.save(commodity);
        return commodity.getId() + commodity.getName();
    }

    @PostMapping("/batchsave")
    public int batchSave(@RequestBody Commodity[] commodityList) {
        try {
            commodityService.batchSave(commodityList);
            return 1;
        } catch (Exception e) {
            return 0;
        }
    }

    @GetMapping("/hello")
    public String hello() {
        return "Hello, World.";
    }

    @Value("${my.name}")
    private String name;

    @GetMapping("/getname")
    public String getConfigInfo() {
        return name;
    }

    @GetMapping("/tran")
    public String execTransaction() {
        Commodity commodity = new Commodity();
        commodity.setName("电动剃须刀");
        commodityService.execTransaction(commodity);
        return "OK";
    }

}