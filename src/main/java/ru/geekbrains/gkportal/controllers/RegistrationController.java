package ru.geekbrains.gkportal.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.geekbrains.gkportal.DTO.House;
import ru.geekbrains.gkportal.DTO.SystemUser;
import ru.geekbrains.gkportal.entities.SystemAccount;
import ru.geekbrains.gkportal.services.HouseService;

import javax.validation.Valid;

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
        SystemAccount account = new SystemAccount();
        account.setHousingNumber(number);
        model.addAttribute("systemUser", account);
        return "reg-form";
    }


    @PostMapping(value = "/userRegister")
    @ResponseBody
    public String registerUser(@Valid @ModelAttribute("systemUser") SystemAccount systemAccount, Model model){
        return systemAccount.toString();


    }
}
