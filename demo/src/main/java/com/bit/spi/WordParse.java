package com.bit.spi;

/**
 * @author chenwei
 * @version 1.0.0
 * @ClassName WordParse.java
 * @Description TODO
 * @createTime 2020年03月02日 11:17:00
 */
public class WordParse implements IParseDoc {

    static {
        System.out.println("WordParse Construct.");
    }

    @Override
    public void parse() {
        System.out.println("解析 word.");
    }
}