package ru.geekbrains.gkportal.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import ru.geekbrains.gkportal.DTO.House;
import ru.geekbrains.gkportal.DTO.HouseSimple;
import ru.geekbrains.gkportal.services.HouseService;

@Controller
public class RegistrationController {
    @Autowired
    HouseService houseService;
    @GetMapping("/showHouse/{number}")
    public String showHouse(@PathVariable(name = "number") int number, Model model){
        House house = houseService.build(number);
        model.addAttribute("house", house);
        return "reg-form";
    }

    @GetMapping("/showHouseSimple/{number}")
    public String showHouseSimple(@PathVariable(name = "number") int number, Model model){
        HouseSimple house = houseService.buildSimple(number);
        model.addAttribute("house", house);
        return "reg-form-new";
    }
}
