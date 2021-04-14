package com.dimon.cars.dao;

import com.dimon.cars.models.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import org.springframework.stereotype.Component;


import java.util.List;

@Component
public class CarDAO {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public CarDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Car> index() {
        return jdbcTemplate.query("select * from car", new BeanPropertyRowMapper<>(Car.class));
    }


    public void save(Car car) {
        jdbcTemplate.update("insert into car (brand, model, engineCapacity, hp, torque, transmission, year) values(?,?,?,?,?,?,?)", car.getBrand(), car.getModel(),
                car.getEngineCapacity(), car.getHp(), car.getTorque(), car.getTransmission(), car.getYear());
    }


    public Car show(int id) {
        return jdbcTemplate.queryForObject("select * from car where id = ?", new Object[]{id}, (resultSet, i) -> {
            Car car = new Car();
            car.setBrand(resultSet.getString("brand"));
            car.setModel(resultSet.getString("model"));
            car.setEngineCapacity(resultSet.getString("engineCapacity"));
            car.setHp(resultSet.getString("hp"));
            car.setTorque(resultSet.getString("torque"));
            car.setTransmission(resultSet.getString("transmission"));
            car.setYear(resultSet.getInt("year"));
            return car;
        });
    }

    public void update(int id, Car car) {
        jdbcTemplate.update("update car set brand=?, model=?, engineCapacity=?, hp=?, torque=?, transmission=?, year=? where id=?", car.getBrand(), car.getModel(),
                car.getEngineCapacity(), car.getHp(), car.getTorque(), car.getTransmission(), car.getYear(), id);
    }

    public void delete(int id) {
        jdbcTemplate.update("delete from car where id=?", id);
    }
}
