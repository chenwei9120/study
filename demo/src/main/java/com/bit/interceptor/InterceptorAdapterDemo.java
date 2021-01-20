package com.bit.interceptor;

import com.bit.basic.Person;
import com.bit.util.SpringManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author chenwei
 * @version 1.0.0
 * @ClassName InterceptorAdapterDemo.java
 * @Description TODO
 * @createTime 2019年12月09日 09:44:00
 */
public class InterceptorAdapterDemo extends HandlerInterceptorAdapter {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println(SpringManager.getBean("person"));
        return true;
    }
}