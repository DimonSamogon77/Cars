package com.dimon.cars.models;


import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

@Getter
@Setter
@AllArgsConstructor
@ToString
@Entity
@Table(name = "Car")
public class Car {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotEmpty(message = "Brand can`t be empty")
    @Column(name = "brand")
    private String brand;

    @NotEmpty(message = "Model can`t be empty")
    @Column(name = "model")
    private String model;

    @NotEmpty(message = "Engine capacity can`t be empty")
    @Column(name = "engineCapacity")
    private String engineCapacity;

    @NotEmpty(message = "Hp can`t be empty")
    @Column(name = "hp")
    private String hp;

    @NotEmpty(message = "Torque can`t be empty")
    @Column(name = "torque")
    private String torque;

    @NotEmpty(message = "Transmission can`t be empty")
    @Column(name = "transmission")
    private String transmission;

    @Min(value = 1769, message = "Car can`t have year less than 1769")
    @Max(value = 2021, message = "Car can`t have year more than 2021")
    @Column(name = "year")
    private int year;

    public Car() {
    }
}
