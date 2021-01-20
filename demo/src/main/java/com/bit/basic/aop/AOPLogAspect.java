package com.bit.basic.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;

import java.util.Arrays;

/**
 * Created by way on 2019/6/10.
 */
@Aspect//Aop 面向切面编程
public class AOPLogAspect {


    @Pointcut("execution(* com.bit.basic.aop.AOPCalculate.*(..))")//定义切入点
    public void pointCut(){};


    @Before(value = "pointCut()")//通知(Advice)
    public void methodBefore(JoinPoint joinPoint){

        String methodName = joinPoint.getSignature().getName();
        System.out.println("执行目标方法【"+methodName+"】之前执行<前置通知>,入参"+ Arrays.asList(joinPoint.getArgs()));
    }

    @After(value = "pointCut()")
    public void methodAfter(JoinPoint joinPoint) {
        String methodName = joinPoint.getSignature().getName();
        System.out.println("执行目标方法【"+methodName+"】之前执行<后置通知>,入参"+Arrays.asList(joinPoint.getArgs()));
    }

    @AfterReturning(value = "pointCut()",returning = "result")
    public void methodReturning(JoinPoint joinPoint, Object result) {
        System.out.println(result);
        String methodName = joinPoint.getSignature().getName();
        System.out.println("执行目标方法【"+methodName+"】之前执行<返回通知>,入参"+Arrays.asList(joinPoint.getArgs()));
    }

    @AfterThrowing(value = "pointCut()")
    public void methodAfterThrowing(JoinPoint joinPoint) {
        String methodName = joinPoint.getSignature().getName();

        System.out.println("执行目标方法【"+methodName+"】之前执行<异常通知>,入参"+Arrays.asList(joinPoint.getArgs()));
    }

/*    @Around(value = "pointCut()")
    public void methodAfterThrowing(ProceedingJoinPoint joinPoint) throws Throwable {
        String methodName = joinPoint.getSignature().getName();
        System.out.println("执行目标方法【"+methodName+"】之前执行<环绕通知>,入参"+joinPoint.getArgs());
        //调用目标方法
        try  {

            joinPoint.proceed();
        } catch (Throwable throwable) {
            System.out.println("调用目标方法异常:"+throwable.getMessage());
            throwable.printStackTrace();
        }
    }*/
}
