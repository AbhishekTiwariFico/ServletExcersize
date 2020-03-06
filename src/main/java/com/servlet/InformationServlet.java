package com.servlet;

import com.model.StudentInfo;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

public class InformationServlet extends HttpServlet {
    static Map<String, StudentInfo> information;
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        StudentInfo s = new StudentInfo();
        s.name = req.getParameter("name");
        s.university = req.getParameter("university");
        s.roll_no = req.getParameter("rollnumber");
         information = new HashMap<>();
        information.put(s.roll_no,s);
        PrintWriter out = resp.getWriter();
        out.write("DATA submitted successfully");

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String roll_no = req.getParameter("rollnumber");
        getServletContext().log(req.getClass().toString());
        PrintWriter out = resp.getWriter();
        Object data = null;
        if(information.containsKey(roll_no))
        {
            data = information.get(roll_no);
                          out.write(data.toString());
        }
        else
        {
            out.write("data not available");
        }
        req.setAttribute("data",data);
    }
}
