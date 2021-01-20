package com.bit.basic;

public class ThreadLocalTest implements Runnable{

    ThreadLocal<Student> studenThreadLocal = new ThreadLocal<Student>();

    @Override
    public void run() {
        Student student = getStudent();
        System.out.println(Thread.currentThread().getName() + " " + student.toString());
    }

    //模拟实际创建对象过程
    private Student getStudent() {
        Student student = studenThreadLocal.get();
        if (null == student) {
            student = new Student();
            String s[] = Thread.currentThread().getName().split(" ");
            student.setName(s[1]);
            student.setAge(Integer.valueOf(s[2]));
            studenThreadLocal.set(student);
        }
        return student;
    }

    public static void main(String[] args) {
        ThreadLocalTest t = new ThreadLocalTest();
        Thread t1 = new Thread(t,"Thread1 Mike 25");
        Thread t2 = new Thread(t,"Thread2 Jack 10");
        t1.start();
        t2.start();
    }
}

class Student{
    private String name;

    private int age;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
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
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
