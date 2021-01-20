package com.example.ioc_test.model;

/**
 * @author chenwei
 * @version 1.0.0
 * @ClassName Student.java
 * @Description TODO
 * @createTime 2020年04月02日 09:10:00
 */
public class Student {
    private Long id;

    private String name;

    public Student(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}