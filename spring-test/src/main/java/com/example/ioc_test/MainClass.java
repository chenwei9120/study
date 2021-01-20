package com.example.ioc_test;

import com.example.ioc_test.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("com.example.ioc_test")
public class MainClass {

    @Autowired
    //@Qualifier("student2")
    private Student student;

//    @Resource(type = Student.class, name = "student")
//    private Student student;

    public Student getStudent() {
        return student;
    }

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MainClass.class);
        MainClass mainClass = context.getBean(MainClass.class);
        System.out.println(mainClass.getStudent());
    }
}
