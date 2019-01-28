package ru.geekbrains.gkportal.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.server.ServerErrorException;
import ru.geekbrains.gkportal.entities.Account;
import ru.geekbrains.gkportal.entities.Role;
import ru.geekbrains.gkportal.services.AccountService;
import ru.geekbrains.gkportal.services.RoleService;

import java.util.Collections;

@Controller
@RequestMapping("/test")
public class TestWebController {

    private AccountService accountService;
    private RoleService roleService;

    @Autowired
    public void setAccountService(AccountService accountService) {
        this.accountService = accountService;
    }

    @Autowired
    public void setRoleService(RoleService roleService) {
        this.roleService = roleService;
    }

    @GetMapping("all")
    public String permitAllPage(Model model) {
//        При изменение данных можно использовать для тестирвоания создания ролей и пользователей
//        Role role = new Role();
//        role.setDescription("admin");
//        role = roleService.save(role);
//
//        Account admin = new Account();
//        admin.setLogin("admin_login");
//        admin.setActive(true);
//        admin.setConfirmed(true);
//        admin.setPasswordHash("$2a$10$NKFyj/dcM.HCT52A2jO/k.Vq52X8F1Yhc2wC2MOaWzkztDcyM6hYu");
//        admin.setRoles(Collections.singletonList(role));
//        accountService.save(admin);
//
//        Role roleManager = new Role();
//        roleManager.setDescription("manager");
//        roleManager = roleService.save(role);
//
//        Account manager = new Account();
//        manager.setLogin("manager_login");
//        manager.setActive(true);
//        manager.setConfirmed(true);
//        manager.setPasswordHash("$2a$10$NKFyj/dcM.HCT52A2jO/k.Vq52X8F1Yhc2wC2MOaWzkztDcyM6hYu");
//        manager.setRoles(Collections.singletonList(roleManager));
//        accountService.save(admin);

        return "test_page";
    }

    @GetMapping("admin")
    public String adminPage() {
        return "test_page";
    }

    @GetMapping("manager")
    public String managerPage() {
        return "test_page";
    }

    @GetMapping("serverErr")
    public String ServerErr() {
        throw new ServerErrorException("test Exception", new Throwable());
    }
}
