package com.pengo.web.servlet;

import org.apache.catalina.Context;
import org.apache.catalina.WebResourceRoot;
import org.apache.catalina.startup.Tomcat;
import org.apache.catalina.webresources.DirResourceSet;
import org.apache.catalina.webresources.StandardRoot;

import java.io.File;

/**
 * @author pengo
 * @description:
 * @date 2022/2/25 21:36
 */
public class ServletDemo {
    public static void main(String[] args) throws Exception{
        Tomcat tomcat = new Tomcat();
        tomcat.setPort(Integer.getInteger("port", 8080));
        tomcat.getConnector();
        Context ctx = tomcat.addWebapp("", new File("/Users/pengo/IdeaProjects/pengo/java_base/src/main/webapp").getAbsolutePath());
        WebResourceRoot resource = new StandardRoot(ctx);
        resource.addPreResources(new DirResourceSet(resource,
                "/WEB-INF/classes", new File("target/classes").getAbsolutePath(), "/"));
        ctx.setResources(resource);
        tomcat.start();
        tomcat.getServer().await();
    }
}
