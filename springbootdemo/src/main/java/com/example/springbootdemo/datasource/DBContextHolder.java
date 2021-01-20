package com.example.springbootdemo.datasource;

import com.example.springbootdemo.enums.config.DBTypeEnum;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author chenwei
 * @version 1.0.0
 * @ClassName DBContextHolder.java
 * @Description TODO
 * @createTime 2019年11月06日 14:36:00
 */
public class DBContextHolder {

    private static Logger logger = LoggerFactory.getLogger(DBContextHolder.class);

    private static final ThreadLocal<DBTypeEnum> contextHolder = new ThreadLocal<>();

    private static final AtomicInteger counter = new AtomicInteger(-1);

    public static void set(DBTypeEnum dbType) {
        contextHolder.set(dbType);
    }

    public static DBTypeEnum get() {
        return contextHolder.get();
    }

    public static void master() {
        set(DBTypeEnum.MASTER);
        logger.info("切换到master");
    }

    public static void slave() {
        //  轮询 现在只有一个slave所以注销掉，主义下面的%2,
//        int index = counter.getAndIncrement() % 2;
//        if (counter.get() > 9999) {
//            counter.set(-1);
//        }
//        if (index == 0) {
            set(DBTypeEnum.SLAVE1);
        logger.info("切换到slave1");
//        }
    }
}