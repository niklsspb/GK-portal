package ru.geekbrains.gkportal.config;

import org.springframework.ui.Model;

public class TemplateNameConst {

    public static final String TEMPLATE_MAIN = "main_template";

    // ============= Главная страницв =========================
    public static final String INDEX_FORM = "index";
    public static final String LOGIN_FORM = "login";

    // ============= обычная регистрация =======================
    // Форма подтверждения аккаунта или опроса по почте
    public static final String REGISTRATION_CONFIRM_MAIL_FORM = "registration/confirm-mail";
    // Форма полной регистрации
    public static final String REGISTRATION_FULL_FORM = "registration/reg-form";
    // Форма быстрой регистрации
    public static final String REGISTRATION_FAST_FORM = "registration/reg-form-fast";
    // Форма регистрация завершена, проверьте почту
    public static final String REGISTRATION_SUCCESS_FROM = "registration/reg-success";

    // ============= регистрация с опросом ======================
    // Форма регистрации с опросом
    public static final String REGISTRATION_QUESTIONNAIRE_FORM = "registration/reg-question-form";
    // Форма регистрация с опросом завершена, проверьте почту
    public static final String REGISTRATION_QUESTIONNAIRE_SUCCES_FORM = "registration/reg-question-success";

    // ============= опросы ==================================
    // Форма результата запроса отправки повторного подтверждающего письма о голосовании
    public static final String QUESTIONNAIRE_CONFIRM_MAIL = "questionnaire/request-confirm-mail";

    // ============= ШАХМАТКА ===================================
    // форма шахматка подъезда
    public static final String SCHEME_PORCH_FORM = "scheme/porch-form";


    /**
     * Автоматизация возврата шаблона
     *
     * @param model    Модель для помещения нужных данных
     * @param template Имя шаблона для включения в общий шаблон
     * @return Имя общего шаблона
     */
    public static String returnShablon(Model model, String template) {
        model.addAttribute("content", template);
        return TEMPLATE_MAIN;
    }


}
