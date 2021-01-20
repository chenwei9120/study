package com.bit.basic.exception;

import java.io.IOException;

/**
 * @author chenwei
 * @version 1.0.0
 * @ClassName App.java
 * @Description TODO
 * @createTime 2019年11月04日 18:01:00
 */
public class App {
    public static void main(String[] args) {
        subMethod(0);
    }

    public static String subMethod(int param)  {
        if (param == 0) {
            //throw new PlatformException(CustomErrorCode.UNKNOW_EXCEPTION);
            throw new RuntimeException("dddd");
            //throw new IOException("dddd");
        }
        return "ADDDD";
    }
}