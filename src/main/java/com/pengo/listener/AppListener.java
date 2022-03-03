package com.pengo.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * @author pengo
 * @description:
 * @date 2022/2/28 11:05
 */
@WebListener
public class AppListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("App initialized...");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("App destroyed...");
    }
}
