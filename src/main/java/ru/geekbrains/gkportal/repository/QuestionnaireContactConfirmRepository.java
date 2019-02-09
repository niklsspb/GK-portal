package ru.geekbrains.gkportal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.geekbrains.gkportal.entity.Contact;
import ru.geekbrains.gkportal.entity.questionnaire.Questionnaire;
import ru.geekbrains.gkportal.entity.questionnaire.QuestionnaireContactConfirm;

@Repository
public interface QuestionnaireContactConfirmRepository extends JpaRepository<QuestionnaireContactConfirm, String> {
    QuestionnaireContactConfirm getByQuestionnaireAndAndContact(Questionnaire questionnaire, Contact contact);

}
