package com.dimon.cars.dao;

import com.dimon.cars.models.Car;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;

@Component
@EnableTransactionManagement
public class CarDAO {
    private final SessionFactory factory;



    @Autowired
    public CarDAO(SessionFactory sessionFactory) {
        this.factory = sessionFactory;
    }

    @Transactional(readOnly = true)
    public List<Car> index() {
        Session session = factory.getCurrentSession();
        return session.createQuery("select p from Car p", Car.class).getResultList();
    }

    @Transactional
    public void save(Car car) {
        Session session = factory.getCurrentSession();
        session.save(car);
    }

    @Transactional(readOnly = true)
    public Car show(int id) {
        Session session = factory.getCurrentSession();
        return session.get(Car.class, id);
    }

    @Transactional
    public void update(Car car, int id) {
        Session session = factory.getCurrentSession();
        Car carToBeUpdated = session.get(Car.class, id);
        carToBeUpdated.setBrand(car.getBrand());
        carToBeUpdated.setModel(car.getModel());
        carToBeUpdated.setEngineCapacity(car.getEngineCapacity());
        carToBeUpdated.setHp(car.getHp());
        carToBeUpdated.setTorque(car.getTorque());
        carToBeUpdated.setTransmission(car.getTransmission());
        carToBeUpdated.setYear(car.getYear());
    }

    @Transactional
    public void delete(int id) {
        Session session = factory.getCurrentSession();
        session.remove(session.get(Car.class, id));
    }
}
