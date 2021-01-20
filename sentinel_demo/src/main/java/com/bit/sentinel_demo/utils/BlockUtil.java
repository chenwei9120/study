package com.bit.sentinel_demo.utils;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import lombok.extern.slf4j.Slf4j;

/**
 * @author chenwei
 * @version 1.0.0
 * @ClassName BlockUtil.java
 * @Description TODO
 * @createTime 2020年02月25日 14:38:00
 */
@Slf4j
public class BlockUtil {

    public static String testHelloSentinelV3BlockMethod(BlockException e) {
        log.info("testHelloSentinelV3方法被流控了");
        return "testHelloSentinelV3方法被流控了";
    }
}