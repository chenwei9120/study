package com.bit.basic.tree;

/**
 * @author admin
 * @version 1.0.0
 * @ClassName IIdentity.java
 * @Description TODO
 * @createTime 2020年04月17日 01:23:00
 */
public interface IIdentity<U, V> {
    U getId();
    V getObject();
    boolean isRoot(U id);

    //V getObjectById(U id);
}