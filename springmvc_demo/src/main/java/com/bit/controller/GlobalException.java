package com.bit.controller;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author chenwei
 * @version 1.0.0
 * @ClassName GlobalException.java
 * @Description 全局异常处理
 * @createTime 2019年11月07日 21:17:00
 */
@Component
public class GlobalException implements HandlerExceptionResolver {

    /**
     * TODO 简单描述该方法的实现功能（可选）.
     *
     * @see org.springframework.web.servlet.HandlerExceptionResolver#resolveException(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse, java.lang.Object, java.lang.Exception)
     */
    @Override
    public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler,
                                         Exception ex) {
        System.out.println(ex.getMessage());
        String exMsg = ex.getMessage();
        ex = null;
        try {
            response.addHeader("Content-Type", "application/json;charset=UTF-8");
            response.getWriter().write("服务器端异常---" + exMsg);
        } catch (IOException e) {
        }
        return null;
    }
}