package com.example.appengine.java8.listner;

import com.example.appengine.java8.dai.Car;
import com.example.appengine.java8.other.SeedData;
import com.googlecode.objectify.ObjectifyService;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class MyListener implements ServletContextListener {


    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        System.out.println("contextInitialized");
        ObjectifyService.init();
        ObjectifyService.register(Car.class);



        someSeedData();
    }

    private void someSeedData() {
        new SeedData().putSeed();
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }
}
