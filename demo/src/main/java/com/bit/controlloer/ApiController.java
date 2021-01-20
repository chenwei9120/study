package com.bit.controlloer;

import com.bit.model.Product;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author chenwei
 * @version 1.0.0
 * @ClassName ApiController.java
 * @Description TODO
 * @createTime 2020年03月23日 13:08:00
 */
@RestController
@RequestMapping("/api")
public class ApiController {

    @GetMapping("/products")
    public Map apiIndex() {
        List<Product> productList = new ArrayList<>();
        productList.add(new Product(1L, 100L, "IPad"));
        productList.add(new Product(2L, 50L, "IPhone"));
        productList.add(new Product(3L, 0L, "HW Mobile"));
        productList.add(new Product(4L, 100L, "Xiaomi Mobile"));
        Map<String, Object> map = new HashMap();
        map.put("products", productList);
        return map;
    }
}