package com.bit.sentinel_demo.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.alibaba.csp.sentinel.slots.block.RuleConstant;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRule;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRuleManager;
import com.bit.sentinel_demo.service.impl.BusiServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

/**
 * @author chenwei
 * @version 1.0.0
 * @ClassName SentinelHelloController2.java
 * @Description TODO
 * @createTime 2020年02月25日 10:51:00
 */
@RestController
public class SentinelHelloController2 {

    @Autowired
    private BusiServiceImpl busiService;

    @PostConstruct
    public void init() {
        //创建流控规则对象
        FlowRule flowRule = new FlowRule();
        //设置流控规则 QPS
        flowRule.setGrade(RuleConstant.FLOW_GRADE_QPS);
        //设置受保护的资源
        flowRule.setResource("helloSentinelV2");
        //设置受保护的资源的阈值
        flowRule.setCount(1);

        List<FlowRule> flowRules = new ArrayList<>();
        flowRules.add(flowRule);
        //加载配置好的规则
        FlowRuleManager.loadRules(flowRules);
    }


    @SentinelResource(value = "helloSentinelV2", blockHandler = "testHelloSentinelV2BlockMethod")
    @RequestMapping("/helloSentinelV2")
    public String testHelloSentinel() throws Exception {
        busiService.doBusi();
        return "OKV2";
    }

    public String testHelloSentinelV2BlockMethod(BlockException e) {
        System.out.println("testHelloSentinelV2方法被流控了....");
        return "testHelloSentinelV2方法被流控了...." + e;
    }
}