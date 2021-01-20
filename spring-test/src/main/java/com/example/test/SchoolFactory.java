package com.example.test;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class SchoolFactory implements FactoryBean<School> {

    public School getObject() {
        School school = new School();
        school.setAddress("杭州大关路123号：");
        school.setSchoolName("大关中学");
        school.setStudentNumber(1000);
        return school;
    }

    public Class<?> getObjectType() {
        return School.class;
    }

    public boolean isSingleton() {
        return true;
    }
}
