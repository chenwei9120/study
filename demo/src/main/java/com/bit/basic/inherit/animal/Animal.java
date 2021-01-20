package com.bit.basic.inherit.animal;

/**
 * @author chenwei
 * @version 1.0.0
 * @ClassName Animal.java
 * @Description TODO
 * @createTime 2019年12月13日 22:37:00
 */
public abstract class Animal {

    public Animal() {
        System.out.println("Animal::Animal");
    }

    public Animal(String typeName) {
        System.out.println("Animal::type=" + typeName);
    }

    public abstract void eat();

    public void test() {
        Animal.this.eat();
        print();
//        if(Animal.this.equals(this)) {
//            System.out.println("equals");
//        } else {
//            System.out.println("not equals");
//        }
    }

    private void print() {
        System.out.println(this.getClass());
    }

    public static void main(String[] args) {
//        Animal animal = new Tiger();
//        animal.test();

        Bird bird = new Bird();
        bird.move();
    }

    public void move() {
        System.out.println("aninal move");
    }

//    @Override
//    protected void finalize() {
//
//    }
}