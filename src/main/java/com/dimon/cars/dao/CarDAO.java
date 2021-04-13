package com.dimon.cars.dao;

import com.dimon.cars.models.Car;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CarDAO {
    private static int CARS_COUNT;
    private List<Car> cars;

    {
        cars = new ArrayList<>();
        cars.add(new Car(++CARS_COUNT, "2021", "Volkswagen", "Tiguan", "1.4", "150", "250", "6AMT"));
        cars.add(new Car(++CARS_COUNT, "2012","Renault", "Fluence", "1.6", "110", "145", "4AT"));
        cars.add(new Car(++CARS_COUNT, "2011", "Renault", "Logan", "1.6", "84", "124", "6MT"));
    }

    public List<Car> index(){
        return cars;
    }

    public void save(Car car){
        car.setId(++CARS_COUNT);
        cars.add(car);
    }

    public Car show(int id){
        return cars.get(id-1);
    }

    public void update(int id, Car car){
        Car carToBeUpdated = show(id);
        carToBeUpdated.setBrand(car.getBrand());
        carToBeUpdated.setModel(car.getModel());
        carToBeUpdated.setEngineCapacity(car.getEngineCapacity());
        carToBeUpdated.setHp(car.getHp());
        carToBeUpdated.setTorque(car.getTorque());
        carToBeUpdated.setTransmission(car.getTransmission());
        carToBeUpdated.setYear(car.getYear());
    }

    public void delete(int id){
        cars.remove(id);
    }

}
