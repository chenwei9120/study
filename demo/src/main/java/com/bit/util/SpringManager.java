package com.bit.util;

import org.springframework.context.ApplicationContext;

public class SpringManager {

    private static ApplicationContext context;

    public static void init(ApplicationContext applicationContext) {
        context = applicationContext;
    }

    public static Object getBean(String name) {
        return context.getBean(name);
    }

    public static <T> T getBean(String name, Class<T> cls) {
        return context.getBean(name, cls);
    }

    /**
     * 根据类型获取bean
     *
     * @param clazz
     * @return
     */
    public static <T> T getBean(Class<T> clazz) {
        String name = clazz.getSimpleName();
        if (name != null && name.length() > 1) {
            name = name.substring(0, 1).toLowerCase() + name.substring(1);
        }
        return context.getBean(name, clazz);
    }
}
