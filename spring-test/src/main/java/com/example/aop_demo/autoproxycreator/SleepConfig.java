package com.example.aop_demo.autoproxycreator;


import org.springframework.aop.framework.ProxyFactoryBean;
import org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator;
import org.springframework.aop.support.DefaultPointcutAdvisor;
import org.springframework.aop.support.JdkRegexpMethodPointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.*;

@Configuration
@ComponentScan("com.example.aop_demo.autoproxycreator")
public class SleepConfig {

    @Autowired(required = false)
    private SleepAspect sleepAspect;

    @Autowired(required = false)
    private JdkRegexpMethodPointcut sleepPointCut;

    @Bean
    public JdkRegexpMethodPointcut sleepPointCut() {
        JdkRegexpMethodPointcut pointcut = new JdkRegexpMethodPointcut();
        pointcut.setPattern(".*sleep");
        return pointcut;
    }

    @Bean
    @DependsOn("sleepPointCut")
    public DefaultPointcutAdvisor sleepAspectAdvisor() {
        DefaultPointcutAdvisor defaultPointcutAdvisor = new DefaultPointcutAdvisor();
        defaultPointcutAdvisor.setAdvice(sleepAspect);
        defaultPointcutAdvisor.setPointcut(sleepPointCut);
        return defaultPointcutAdvisor;
    }

    @Bean
    public DefaultAdvisorAutoProxyCreator defaultAdvisorAutoProxyCreator() {
        return new DefaultAdvisorAutoProxyCreator();
    }
}
