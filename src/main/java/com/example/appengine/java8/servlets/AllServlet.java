package com.example.appengine.java8.servlets;

import com.example.appengine.java8.dai.Car;
import com.google.gson.Gson;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import static com.googlecode.objectify.ObjectifyService.ofy;

@WebServlet(name = "AllServlet", value = "/all")
public class AllServlet extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException {

        response.setContentType("application/json");

        List<Car> carList = ofy().load().type(Car.class).list();

        response.getWriter().println(new Gson().toJson(carList));

    }
}
