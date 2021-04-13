package com.dimon.cars.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Car {
    private int id, year;
    private String brand, model, engineCapacity, hp, torque, transmission;

    public Car() {

    }

    public Car(int id, int year, String brand, String model, String engineCapacity, String hp, String torque, String transmission) {
        this.id = id;
        this.year = year;
        this.brand = brand;
        this.model = model;
        this.engineCapacity = engineCapacity;
        this.hp = hp;
        this.torque = torque;
        this.transmission = transmission;
    }
}
