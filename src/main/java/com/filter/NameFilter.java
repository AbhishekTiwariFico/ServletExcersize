package com.filter;


import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.PrintWriter;

public class NameFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain) throws IOException, ServletException {
        if (((HttpServletRequest)servletRequest).getMethod().equals("POST"))
        {
            int flag = 0;
            String name = servletRequest.getParameter("name");
            PrintWriter out = servletResponse.getWriter();
            char[] nameChar = name.toCharArray();
            for (char ch : nameChar) {
                if (Character.valueOf(ch) >= 65 && Character.valueOf(ch) <= 122) {
                    continue;
                } else {
                    flag = 1;
                    out.print("Enter valid  name");
                    break;
                }
            }
            if (flag == 0) {
                chain.doFilter(servletRequest, servletResponse);
            }
        }
        else
        {
            chain.doFilter(servletRequest, servletResponse);
        }
    }

    @Override
    public void destroy() {

    }
}
