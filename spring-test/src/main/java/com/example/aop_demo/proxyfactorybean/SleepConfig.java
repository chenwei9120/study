package com.example.aop_demo.proxyfactorybean;


import org.springframework.aop.framework.ProxyFactoryBean;
import org.springframework.aop.support.DefaultPointcutAdvisor;
import org.springframework.aop.support.JdkRegexpMethodPointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;

@Configuration
@ComponentScan("com.example.aop_demo.proxyfactorybean")
public class SleepConfig {

    @Autowired(required = false)
    private SleepAspect sleepAspect;

    @Autowired(required = false)
    private JdkRegexpMethodPointcut sleepPointCut;

    @Autowired(required = false)
    private Human human;


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
    public ProxyFactoryBean humanProxy() throws ClassNotFoundException {
        ProxyFactoryBean bean = new ProxyFactoryBean();
        bean.setTarget(human);
        bean.setInterceptorNames("sleepAspectAdvisor");
        Class<?>[] proxyInterfaces = new Class[1];
        proxyInterfaces[0] = Sleepable.class;
        bean.setProxyInterfaces(proxyInterfaces);
        return bean;
    }
}
