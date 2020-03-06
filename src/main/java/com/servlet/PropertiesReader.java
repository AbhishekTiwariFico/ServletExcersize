package com.servlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Properties;

public class PropertiesReader extends HttpServlet {
    ServletContext context;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();
        Properties p = (Properties) getServletContext().getAttribute("properties");
         context= getServletContext();
         context.log(p.getProperty("name"));
         out.println(p.getProperty("name"));
        out.println(p.getProperty("rollnumber"));
        out.println(p.getProperty("university"));

    }
}
