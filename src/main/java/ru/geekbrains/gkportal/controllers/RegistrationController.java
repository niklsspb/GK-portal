package ru.geekbrains.gkportal.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.geekbrains.gkportal.DTO.House;
import ru.geekbrains.gkportal.DTO.SystemUser;
import ru.geekbrains.gkportal.services.HouseService;

@Controller
public class RegistrationController {

    private HouseService houseService;

    @Autowired
    public void setHouseService(HouseService houseService) {
        this.houseService = houseService;
    }

    @GetMapping("/showHouse/{number}")
    public String showHouse(@PathVariable(name = "number") int number, Model model){
        House house = houseService.build(number);
        model.addAttribute("house", house);
        model.addAttribute("systemUser", new SystemUser());
        return "reg-form";
    }


    @PostMapping("/userRegister")
    @ResponseBody
    public String registerUser(@ModelAttribute("systemUser") SystemUser systemUser, Model model){
        return systemUser.toString();

    }
}
