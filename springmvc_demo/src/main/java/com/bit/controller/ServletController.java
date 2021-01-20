package com.bit.controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author chenwei
 * @version 1.0.0
 * @ClassName ServletController.java
 * @Description TODO
 * @createTime 2019年11月21日 17:06:00
 */
public class ServletController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        if(req.getSession().getAttribute("word") == null) {
            System.out.println(req.getSession().getAttribute("word"));
            req.getSession().setAttribute("word", "12345");
        } else {
            resp.getWriter().print(req.getSession().getAttribute("word"));
            System.out.println(req.getSession().getAttribute("word"));
        }
//        resp.getWriter().println("hello.world.");
    }
}