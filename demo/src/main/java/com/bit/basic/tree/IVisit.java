package com.bit.basic.tree;

/**
 * @author admin
 * @version 1.0.0
 * @ClassName IVisit.java
 * @Description TODO
 * @createTime 2020年04月17日 01:03:00
 */
public interface IVisit<T> {
    void visit(T nodeValue);
}