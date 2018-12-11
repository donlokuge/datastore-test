package com.example.appengine.java8.servlets;

import com.google.appengine.api.utils.SystemProperty;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Properties;

import static com.googlecode.objectify.ObjectifyService.ofy;


@WebServlet(name = "CarServlet", value = "/car")
public class CarServlet extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        Properties properties = System.getProperties();

        response.setContentType("text/plain");

        com.example.appengine.java8.dai.Car car = new com.example.appengine.java8.dai.Car("1234",1);

        ofy().save().entity(car).now();

        response.getWriter().println("car id : "+car.getId());

    }
}
