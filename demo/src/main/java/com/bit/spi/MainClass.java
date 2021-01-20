package com.bit.spi;

import java.io.IOException;
import java.util.Iterator;
import java.util.ServiceLoader;

/**
 * @author chenwei
 * @version 1.0.0
 * @ClassName MainClass.java
 * @Description TODO
 * @createTime 2020年03月02日 11:16:00
 */
public class MainClass {
    public static void main(String[] args) throws IOException {
        ServiceLoader<IParseDoc> serviceLoader = ServiceLoader.load(IParseDoc.class);
        Iterator<IParseDoc> iParseDocIterator = serviceLoader.iterator();
        while (iParseDocIterator.hasNext()) {
            iParseDocIterator.next().parse();
        }
        System.in.read();
    }
}