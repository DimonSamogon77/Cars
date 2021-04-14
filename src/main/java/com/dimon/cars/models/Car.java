package com.dimon.cars.models;


import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

@Getter
@Setter
public class Car {
    private int id;

    @NotEmpty(message = "Brand can`t be empty")
    private String brand;

    @NotEmpty(message = "Model can`t be empty")
    private String model;

    @NotEmpty(message = "Engine capacity can`t be empty")
    private String engineCapacity;

    @NotEmpty(message = "Hp can`t be empty")
    private String hp;

    @NotEmpty(message = "Torque can`t be empty")
    private String torque;

    @NotEmpty(message = "Transmission can`t be empty")
    private String transmission;

    @Min(value = 1769, message = "Car can`t have year less than 1769")
    @Max(value = 2021, message = "Car can`t have year more than 2021")
    private int year;

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
