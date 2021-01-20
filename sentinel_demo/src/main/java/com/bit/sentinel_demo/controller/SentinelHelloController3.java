package com.bit.sentinel_demo.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.RuleConstant;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRule;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRuleManager;
import com.bit.sentinel_demo.service.impl.BusiServiceImpl;
import com.bit.sentinel_demo.utils.BlockUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

/**
 * @author chenwei
 * @version 1.0.0
 * @ClassName SentinelHelloController3.java
 * @Description TODO
 * @createTime 2020年02月25日 14:39:00
 */
@RestController
public class SentinelHelloController3 {

    @Autowired
    private BusiServiceImpl busiService;

    @PostConstruct
    public void init() {
        List<FlowRule> flowRules = new ArrayList<>();
        /**
         * 定义 helloSentinelV3 受保护的资源的规则
         */
        //创建流控规则对象
        FlowRule flowRule = new FlowRule();
        //设置流控规则 QPS
        flowRule.setGrade(RuleConstant.FLOW_GRADE_QPS);
        //设置受保护的资源
        flowRule.setResource("helloSentinelV3");
        //设置受保护的资源的阈值
        flowRule.setCount(1);
        flowRules.add(flowRule);

        //加载配置好的规则
        FlowRuleManager.loadRules(flowRules);
    }

    /**
     * 我们看到了v2中的缺点,我们通过blockHandlerClass 来指定处理被流控的类
     * 通过testHelloSentinelV3BlockMethod 来指定blockHandlerClass 中的方法名称
     * ***这种方式 处理异常流控的方法必须要是static的
     * 频繁请求接口 http://localhost:8080/helloSentinelV3
     *
     * @return
     */
    @RequestMapping("/helloSentinelV3")
    @SentinelResource(value = "helloSentinelV3", blockHandler = "testHelloSentinelV3BlockMethod",
            blockHandlerClass = BlockUtil.class)
    public String testHelloSentinelV3() {
        busiService.doBusi();
        return "OKV3";
    }
}