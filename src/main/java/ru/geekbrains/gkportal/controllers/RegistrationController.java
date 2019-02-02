package ru.geekbrains.gkportal.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import ru.geekbrains.gkportal.DTO.House;
import ru.geekbrains.gkportal.entities.SystemAccount;
import ru.geekbrains.gkportal.services.AccountService;
import ru.geekbrains.gkportal.services.ContactTypeService;
import ru.geekbrains.gkportal.services.HouseService;

import javax.validation.Valid;

@Controller
public class RegistrationController {

    private HouseService houseService;
    private ContactTypeService contactTypeService;
    private AccountService accountService;

    @Autowired
    public void setAccountService(AccountService accountService) {
        this.accountService = accountService;
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
    public String showHouse(@PathVariable(name = "number") int number, Model model) {
        House house = houseService.build(number);
        model.addAttribute("house", house);
        SystemAccount account = new SystemAccount();
        account.setHousingNumber(number);
        model.addAttribute("systemUser", account);
        model.addAttribute("userTypes", contactTypeService.getAllContactTypes());
        return "reg-form";
    }


    @PostMapping(value = "/userRegister")
    public String registerUser(@Valid @ModelAttribute("systemUser") SystemAccount systemAccount, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            createErrorModel(systemAccount, model, "проверьте правильность заполненых полей");
            return "reg-form";
        }

        if (accountService.isLoginExist(systemAccount.getLogin())) {
            createErrorModel(systemAccount, model, "Указанный логин уже существует");
            return "reg-form";
        }

        try {
            accountService.createAccount(systemAccount);
            return "reg-success";
        } catch (Throwable throwable) {
            throwable.printStackTrace(); // TODO: 02.02.2019 to Log
            createErrorModel(systemAccount, model, "Произошла непредвиденная ошибка");
            return "reg-form";
        }


    }

    private void createErrorModel(SystemAccount systemAccount, Model model, String error) {
        House house = houseService.build(systemAccount.getHousingNumber());
        model.addAttribute("house", house);
        model.addAttribute("userTypes", contactTypeService.getAllContactTypes());
        model.addAttribute("registrationError", error);
    }

   /* @ModelAttribute("interests")
    public String[] getMultiCheckboxAllValues() {
        return new String[] {
                "Место в паркинге", "Детский сад", "Школа"
        };
    }*/
}
