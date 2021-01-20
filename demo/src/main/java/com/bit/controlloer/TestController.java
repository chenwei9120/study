package com.bit.controlloer;

import com.bit.model.Product;
import com.bit.service.HelloService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping
@Slf4j
public class TestController {

    private final Logger logger = LoggerFactory.getLogger(TestController.class);

    @Autowired
    HelloService helloService;

    @Autowired
    private StringRedisTemplate stringRedisTemplate;


    @PostMapping("/test")
    @ResponseBody
    public boolean create(@RequestParam String str, @RequestParam String str2) {//
        System.out.println(str + str2);
        return true;
    }

    @RequestMapping("/index")
    @ResponseBody
    public String index() {
        return "Hello World.";
    }

    @RequestMapping("/redis")
    @ResponseBody
    public String redis() {
        if (!stringRedisTemplate.hasKey("test1234")) {
            stringRedisTemplate.opsForValue().set("test1234", "I am superman.");
        }
        return stringRedisTemplate.opsForValue().get("test1234");
    }

    @RequestMapping("/gateWay4Header")
    public Object gateWay4Header(@RequestHeader("X-Request-Company") String company) {

        return "gateWay拿到请求头" + company;
    }

    @RequestMapping("/getproducts")
    public Map getProducts() {
        List<Product> productList = new ArrayList<>();
        productList.add(new Product(1L, 100L, "IPad"));
        productList.add(new Product(2L, 50L, "IPhone"));
        productList.add(new Product(3L, 0L, "HW Mobile"));
        productList.add(new Product(4L, 100L, "Xiaomi Mobile"));
        Map<String, Object> map = new HashMap();
        map.put("products", productList);
        return map;
    }

    @RequestMapping("/getTokenHeader")
    public String getTokenHeader(@RequestHeader("Token")String token) {
        log.info("token:{}", token);
        return token;
    }
}
