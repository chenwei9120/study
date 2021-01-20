package com.bit.filter;

import javax.servlet.*;
import java.io.IOException;

public class MyFilter implements Filter {

    @Override
    public void destroy() {
        System.out.println("destroy");
    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) {
        System.out.println("doFilter begin");
        try {
            chain.doFilter(req,res);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ServletException e) {
            e.printStackTrace();
        }
        System.out.println("doFilter end");
    }

    @Override
    public void init(FilterConfig config) throws ServletException {
        System.out.println("MyFilter::init. filterName=" + config.getFilterName() + ";initParameterValue" + config.getInitParameter("paramName"));
    }

}
