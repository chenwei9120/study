package com.bit.controller;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author chenwei
 * @version 1.0.0
 * @ClassName CustomInterceptor.java
 * @Description TODO
 * @createTime 2019年11月07日 20:56:00
 */
public class CustomInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object handle) throws Exception {
        System.out.println("preHandler");
        System.out.println(handle.getClass().getSimpleName());
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object handle, ModelAndView modelAndView) throws Exception {
        System.out.println("postHandle");
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handle, Exception e) throws Exception {
        System.out.println("afterCompletion");
    }
}