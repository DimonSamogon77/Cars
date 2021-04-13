package com.dimon.cars.dao;

import com.dimon.cars.models.Car;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CarDAO {
    private List<Car> cars;

    {
        cars = new ArrayList<>();
        cars.add(new Car(1, 2021, "Volkswagen", "Tiguan", "1.4", "150", "250", "6AMT"));
        cars.add(new Car(2, 2012,"Renault", "Fluence", "1.6", "110", "145", "4AT"));
        cars.add(new Car(3, 2011, "Renault", "Logan", "1.6", "84", "124", "6MT"));
    }

    public List<Car> index(){
        return cars;
    }

    public Car show(int id){
        return cars.get(id);
    }

}
