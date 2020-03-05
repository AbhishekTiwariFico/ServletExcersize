package com.filter;

import javax.servlet.*;
import java.io.IOException;
import java.io.PrintWriter;


public class RollNumberFilter implements Filter {

    public void init(FilterConfig config) {

    }

    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {

        int flag = 0;
        PrintWriter out = res.getWriter();
        String rollNo = req.getParameter("rollnumber");

        char[] roll = rollNo.toCharArray();
        if ((roll[0] == 'R' || roll[0] == 'r') && (roll[1] == 'N' || roll[1] == 'n')) {
            for (int i = 2; i < roll.length; i++) {

                if (Character.isDigit(roll[i])) {
                    continue;
                } else {

                    flag++;
                    break;

                    //RequestDispatcher rd=req.getRequestDispatcher("index.jsp");
                    // rd.include(req, res);
                }
            }
        }
        else
        {
            flag++;
        }
        if (flag == 0) {
            chain.doFilter(req, res);
        }
        else {

            out.print("Enter correct roll number");
        }

    }



    @Override
    public void destroy() {

    }

}
