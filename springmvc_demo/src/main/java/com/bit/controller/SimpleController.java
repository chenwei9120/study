package com.bit.controller;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SimpleController implements Controller {

    @Override
    public ModelAndView handleRequest(HttpServletRequest httpServletRequest,
                                      HttpServletResponse httpServletResponse) throws Exception {
        ModelAndView modelAndView = new ModelAndView("/WEB-INF/web/index.jsp");
        modelAndView.addObject("serverContent", "Hello, World.");
        return modelAndView;
    }
}
