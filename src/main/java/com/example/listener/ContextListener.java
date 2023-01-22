package com.example.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;
import java.time.LocalDateTime;

@WebListener
public class ContextListener implements ServletRequestListener {
    //write your code here!

    public void contextInitialized(ServletContextEvent e){
        e.getServletContext().setAttribute("servletTimeInit",
                LocalDateTime.now());
    }

}
