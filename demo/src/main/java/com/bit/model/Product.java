package com.bit.model;

/**
 * @author chenwei
 * @version 1.0.0
 * @ClassName Product.java
 * @Description TODO
 * @createTime 2020年03月20日 00:42:00
 */
public class Product {
    public Product(Long id, Long quantity, String name) {
        this.id = id;
        this.quantity = quantity;
        this.name = name;
    }

    private Long id;
    private Long quantity;
    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getQuantity() {
        return quantity;
    }

    public void setQuantity(Long quantity) {
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}