package ru.geekbrains.gkportal.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.geekbrains.gkportal.service.MailService;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/test")
public class TestControllers {

    private MailService mailService;

    @Autowired
    public void setMailService(MailService mailService) {
        this.mailService = mailService;
    }

    @GetMapping("/email")
    public int sendMail() {
        mailService.sendRegistrationMail("admin@chertenok.ru");
        return HttpStatus.OK.value();
    }

    @GetMapping("/emailGroup")
    public int sendMailGroup() {

        String subject = "ЖК Город. Сбор голосов по ООС";
        String text = "Здравствуйте! \n\n Вы получили это письмо, т.к. зарегистрировались в шахматке. \n\n " +
                "Как Вы знаете, до 20.02 проходит собрание собственников. Начиная с 21.02 будет работать счётная\n" +
                " комиссия, для подведения итогов голосования. В её состав входят представители ИГ и просто собственники.\n" +
                "Для контроля правильности подсчёта голосов, просим Вас заполнить анкету на сайте, по адресу ниже.\n\n" +
               
                "Анкету надо заполнить один раз на каждого собственника, указав весь список Вашей недвижимости. \n" +
                "Телефон нужен для того, чтобы связаться с Вами при выявлении несостыковок с бумажной анкетой.\n" +
                "После заполнения нужно будет подтвердить ваш опрос по ссылке присланной на указанный Вами емайл.\n" +
                "Если у Вас несколько собственников, то после заполнения анкеты первогособственника, \n" +
                "Вам будет предложена ссылка на упрощенное заполнение данных для других владельцев этих же объектов.\n\n" +
                "Обратите внимание, все данные вносятся по АПП - площадь, адрес (строительный).\n\n" +
                "Анкету можно заполнить только один раз на человека.\n\n" +
                "С Уважением, инициативная группа ЖК Город";
        List<String> mails = Arrays.asList("");


        mailService.sendMail(mails, subject, text, false);


        return HttpStatus.OK.value();
    }


}
