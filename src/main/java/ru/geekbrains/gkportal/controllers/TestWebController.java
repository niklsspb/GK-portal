package ru.geekbrains.gkportal.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.server.ServerErrorException;
import ru.geekbrains.gkportal.entities.questionnaire.Questionnaire;
import ru.geekbrains.gkportal.entities.questionnaire.QuestionnaireQuestion;
import ru.geekbrains.gkportal.entities.questionnaire.QuestionnaireQuestionAnswer;
import ru.geekbrains.gkportal.services.AccountService;
import ru.geekbrains.gkportal.services.RoleService;

import java.time.LocalDateTime;
import java.util.*;

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

    @GetMapping("uuidGenerator")
    public String permitAllPage(Model model) {

        List<String> uuidList = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            uuidList.add(UUID.randomUUID().toString());
        }

        model.addAttribute("uuids", uuidList);


        List<QuestionnaireQuestionAnswer> qqaList = new ArrayList<>(Arrays.asList(
                new QuestionnaireQuestionAnswer("Я не принимаю участия в голосовании (бюллетень остался у меня)", 4),
                new QuestionnaireQuestionAnswer("ЗА", 1),
                new QuestionnaireQuestionAnswer("ПРОТИВ", 2),
                new QuestionnaireQuestionAnswer("Воздержался", 3)
        ));


        QuestionnaireQuestion qq1 = QuestionnaireQuestion.builder()
                .name("Ваше решение по работе УК Еврогород *")
                .sortNumber(1)
                .required(true)
                .single(true)
                .externalNumber(1)
                .questionnaireQuestionAnswerList(qqaList)
                .build();

        Questionnaire questionnaire = Questionnaire.builder()
                .name("Опрос о голосовании (exit pool) собственников ЖК Город")
                .from(LocalDateTime.now())
                .to(LocalDateTime.now().plusMonths(1L))
                .description("Члены инициативной группы входящие в состав счетной комиссии выборочно проверят " +
                        "соответствие информации в данном опросе и в бюллетенях в момент подведения итогов первого " +
                        "общего собрания собственников. Доступ к данным имеют ограниченное число членов инициативной " +
                        "группы ЖК Город. \n Форму должен заполнить каждый собственник отдельно по каждому объекту " +
                        "недвижимости(квартиры, машиноместа), где у него есть доля.")
                .open(true)
                .active(true)
                .inBuildNum(true)
                .useRealEstate(true)
                .questionnaireQuestionList(Collections.singletonList(qq1))
                .build();

        System.out.println(questionnaire);

//        При изменение данных можно использовать для тестирвоания создания ролей и пользователей
//        Role role = new Role();
//        role.setDescription("habitant");
//        role = roleService.save(role);
//
//        Account habitant = new Account();
//        habitant.setLogin("habitant_login");
//        habitant.setActive(true);
//        habitant.setConfirmed(true);
//        habitant.setPasswordHash("$2a$10$NKFyj/dcM.HCT52A2jO/k.Vq52X8F1Yhc2wC2MOaWzkztDcyM6hYu");
//        habitant.setRoles(Collections.singletonList(role));
//        accountService.save(habitant);
//
//        Role roleManager = new Role();
//        roleManager.setDescription("manager");
//        roleService.save(role);

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
