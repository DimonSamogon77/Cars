package com.dimon.cars.controllers;

import com.dimon.cars.dao.CarDAO;
import com.dimon.cars.models.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/cars")
public class CarsController {
    private CarDAO carDAO;

    @Autowired
    public CarsController(CarDAO carDAO) {
        this.carDAO = carDAO;
    }

    @GetMapping("/index")
    public String index(Model model){
        model.addAttribute("cars", carDAO.index());
        return "cars/index";
    }

    @GetMapping("/new")
    public String newCar(@ModelAttribute("car") Car car){
        return "cars/new";
    }

    @PostMapping()
    public String create(@ModelAttribute("car") Car car){
        carDAO.save(car);
        return "redirect:/cars/index";
    }

    @GetMapping("/{id}/edit")
    public String edit(Model model, @PathVariable("id") int id){
        model.addAttribute(carDAO.show(id));
        return "cars/edit";
    }

    @PutMapping("/{id}")
    public String update(@ModelAttribute("car") Car car, @PathVariable("id") int id){
        carDAO.update(id, car);
        return "redirect:/cars/index";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") int id){
        carDAO.delete(id);
        return "redirect:/cars/index";
    }

}
