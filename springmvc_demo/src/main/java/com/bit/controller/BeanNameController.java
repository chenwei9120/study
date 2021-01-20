package com.bit.controller;

import org.springframework.web.HttpRequestHandler;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class BeanNameController implements HttpRequestHandler {

    @Override
    public void handleRequest(HttpServletRequest httpServletRequest,
                              HttpServletResponse httpServletResponse) throws ServletException, IOException {
        httpServletRequest.setAttribute("serverContent", httpServletRequest.getRequestURI());
        httpServletRequest.getRequestDispatcher("/WEB-INF/web/index.jsp").forward(httpServletRequest, httpServletResponse);
    }
}
