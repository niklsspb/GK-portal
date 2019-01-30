package ru.geekbrains.gkportal.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ru.geekbrains.gkportal.DTO.House;
import ru.geekbrains.gkportal.DTO.SystemUser;
import ru.geekbrains.gkportal.entities.Contact;
import ru.geekbrains.gkportal.entities.Flat;
import ru.geekbrains.gkportal.entities.SystemAccount;
import ru.geekbrains.gkportal.services.ContactTypeService;
import ru.geekbrains.gkportal.services.HouseService;
import ru.geekbrains.gkportal.services.RegistrationService;

import javax.validation.Valid;
import java.util.Optional;

@Controller
public class RegistrationController {

    private HouseService houseService;
    private ContactTypeService contactTypeService;
    private RegistrationService registrationService;

    @Autowired
    public void setRegistrationService(RegistrationService registrationService) {
        this.registrationService = registrationService;
    }

    @Autowired
    public void setContactTypeService(ContactTypeService contactTypeService) {
        this.contactTypeService = contactTypeService;
    }

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
        model.addAttribute("userTypes", contactTypeService.getAllContactTypes());
        return "reg-form";
    }


    @PostMapping(value = "/userRegister")
    public String registerUser(@Valid @ModelAttribute("systemUser") SystemAccount systemAccount, BindingResult bindingResult,  Model model){
        if(bindingResult.hasErrors()){
            House house = houseService.build(systemAccount.getHousingNumber());//TODO засунуть в сессию, чтобы по 10 раз не дёргать базу
            model.addAttribute("house", house);
            model.addAttribute("userTypes", contactTypeService.getAllContactTypes());
            return "reg-form";
        }
        if (registrationService.registerNewUser(systemAccount)){
            return "reg-success";
        }
        else {
            House house = houseService.build(systemAccount.getHousingNumber());//TODO засунуть в сессию, чтобы по 10 раз не дёргать базу
            model.addAttribute("house", house);
            model.addAttribute("userTypes", contactTypeService.getAllContactTypes());
            model.addAttribute("registrationError", "Произошла какая-то ошибка, в будущем мы даже будем писать, какая");
            return "reg-form";
        }


    }

   /* @ModelAttribute("interests")
    public String[] getMultiCheckboxAllValues() {
        return new String[] {
                "Место в паркинге", "Детский сад", "Школа"
        };
    }*/
}
