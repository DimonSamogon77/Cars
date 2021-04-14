package com.dimon.cars.controllers;

import com.dimon.cars.dao.CarDAO;
import com.dimon.cars.models.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("/cars")
public class CarsController {
    private final CarDAO carDAO;

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
    public String create(@ModelAttribute("car") @Valid Car car,
                         BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return "cars/new";
        }
        carDAO.save(car);
        return "redirect:/cars/index";
    }

    @GetMapping("/{id}/edit")
    public String edit(Model model, @PathVariable("id") int id){
        model.addAttribute(carDAO.show(id));
        return "cars/edit";
    }

    @PatchMapping("/{id}")
    public String update(@ModelAttribute("car") @Valid Car car,BindingResult bindingResult, @PathVariable("id") int id){
        if(bindingResult.hasErrors()){
            return "cars/edit";
        }
        carDAO.update(car, id);
        return "redirect:/cars/index";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") int id){
        carDAO.delete(id);
        return "redirect:/cars/index";
    }

}
