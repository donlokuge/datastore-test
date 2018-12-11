package com.example.appengine.java8.other;

import com.example.appengine.java8.dai.Car;
import com.googlecode.objectify.ObjectifyService;
import com.googlecode.objectify.Work;

import java.util.List;

import static com.googlecode.objectify.ObjectifyService.ofy;

public class SeedData {


    public void putSeed() {

        ObjectifyService.run(new Work<Car>() {
            @Override
            public Car run() {
                List<Car> carList = ofy().load().type(Car.class).list();
                if (carList == null || carList.isEmpty()) {
                    for (int i = 0; i < 10l; i++) {
                        Car car = new Car("REG" + i, 0);
                        ofy().save().entity(car).now();
                    }
                } else {
                    System.out.println("Seed skipped for cars");
                }
                return null;
            }
        });
    }
}
