package com.bit.controlloer;

import lombok.extern.slf4j.Slf4j;

/**
 * @author chenwei
 * @version 1.0.0
 * @ClassName LogTest
 * @Description TODO
 * @createTime 2020-12-21 13:27:00
 */
@Slf4j
public class LogTest {
    public static void main(String[] args) {
        try {
            int i = 0;
            log.error("Hello, {}", 1234);
            int j = 2 /i;
        } catch (Exception e) {
            log.error("error is {}", e.getMessage());
        }
    }
}
