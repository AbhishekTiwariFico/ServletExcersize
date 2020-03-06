package com.Listener;

import javax.servlet.*;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class SystemListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        ServletContext sc = servletContextEvent.getServletContext();
        String path = sc.getInitParameter("path");
        InputStream in = null;
        try {
            in = new FileInputStream(path);
            Properties p = new Properties();
            p.load(in);
            sc.setAttribute("properties",p);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

   }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }
}
