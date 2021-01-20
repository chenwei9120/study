package com.bit.interceptor;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class InterceptorDemo extends HandlerInterceptorAdapter {

    @Override
    public void afterCompletion(HttpServletRequest req,
                                HttpServletResponse res, Object handler, Exception e) throws Exception {
        System.out.println("InterceptorDemo::afterCompletion");
    }


    @Override
    public void postHandle(HttpServletRequest req, HttpServletResponse res,
                           Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("InterceptorDemo::postHandle");
    }

    @Override
    public boolean preHandle(HttpServletRequest req, HttpServletResponse res,
                             Object handler) throws Exception {
//        HandlerMethod method = (HandlerMethod)handler;
//        String className = method.getBeanType().getSimpleName();
//        String methodName = method.getMethod().getName();
        System.out.println("InterceptorDemo::preHandle");
        return true;
    }
}
