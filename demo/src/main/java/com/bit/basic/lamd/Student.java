package com.bit.basic.lamd;

/**
 * @author chenwei
 * @version 1.0.0
 * @ClassName Student
 * @Description TODO
 * @createTime 2020-11-13 15:16:00
 */


public class Student {
    int age;
    String username;
    String code;

    public Student() {
    }

    public Student(int age, String username, String code) {
        this.age = age;
        this.username = username;
        this.code = code;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return "Student{" + "age=" + age + ", username='" + username + '\'' + ", code='" + code + '\'' + '}';
    }
}
