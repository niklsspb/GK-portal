package ru.geekbrains.gkportal.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import ru.geekbrains.gkportal.entities.Account;
import ru.geekbrains.gkportal.entities.Contact;
import ru.geekbrains.gkportal.repository.AccountRepository;


@Controller
public class PersonAreaController {

    private AccountRepository accountRepository;

    @Autowired
    public void setAccountRepository(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @GetMapping("/lk/{login}")
    public String personArea (@PathVariable(name = "login") String login, Model model) {
        Account account =  accountRepository.findOneByLogin(login);
        if (!account.isActive()) {
            return "login";
        }
        Contact contact = account.getContact();
        model.addAttribute("contact", contact);
        return "lk";
    }
}
