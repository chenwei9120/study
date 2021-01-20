package com.bit.basic.classloader;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Timer;
import java.util.TimerTask;

/**
 * @author chenwei
 * @version 1.0.0
 * @ClassName App.java
 * @Description TODO
 * @createTime 2019年11月05日 14:27:00
 */
public class App {
    private static java.util.Timer timer = new Timer(false);

    public static void main(String[] args) throws IOException {
//        File file = new File("D:\\Code\\Java\\study\\demo\\src\\main\\java\\com\\bit\\basic\\classloader\\swap");
//        File file = new File("./swap");
//        System.out.println(file.getCanonicalPath());
//        if(file.exists()) {
//            System.out.println("Foo.class存在");
//        } else {
//            System.out.println("Foo.class不存在");
//        }
        System.out.println("Hello");
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                try {
                    HotswapCL cl = new HotswapCL("D:\\Code\\Java\\study\\demo\\src\\main\\java\\com\\bit\\basic\\classloader\\swap", new String[]{"Foo"});//at cmd window
                    //HotswapCL cl = new HotswapCL("src/swap", new String[] { "Foo" });//at program
                    Class<?> cls = cl.loadClass("Foo");
                    Object foo = cls.newInstance();

                    Method m = foo.getClass().getMethod("sayHello", new Class[]{});
                    m.invoke(foo, new Object[]{});

                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        };
        timer.schedule(task, 2000, 2000);
    }

}