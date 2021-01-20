package com.bit.config;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.context.annotation.Configuration;

@Aspect
@Configuration
public class AOPConfig {
    /*
     * 定义一个切入点
     */
    // @Pointcut("execution (* findById*(..))")
    @Pointcut("execution(* com.bit.controlloer.*.*(..))")
    public void pointCut(){}

    /*
     * 通过连接点切入
     */
//    @Before(value="pointCut()")
//    public void before(JoinPoint joinPoint) throws Exception{
//        Object target = joinPoint.getTarget();
//        String methodName = joinPoint.getSignature().getName();
//        System.out.println(target + "-------" + methodName);
//        Method method = target.getClass().getMethod(methodName);
//        boolean annotationPresent = method.isAnnotationPresent(RequiresLogin.class);
//        if (annotationPresent) {
//            // 用户必须登录
//            boolean isLogin = false;
//            if (!isLogin) {
//                throw new Exception("访问该接口必须先登录");
//            } else {
//                System.out.println("已登录...");
//            }
//        }
//    }
}
