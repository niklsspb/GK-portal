package ru.geekbrains.gkportal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.geekbrains.gkportal.entity.Contact;
import ru.geekbrains.gkportal.entity.questionnaire.Questionnaire;
import ru.geekbrains.gkportal.entity.questionnaire.QuestionnaireContactConfirm;
import ru.geekbrains.gkportal.entity.questionnaire.QuestionnaireContactConfirmDTO;

import java.util.List;

@Repository
public interface QuestionnaireContactConfirmRepository extends JpaRepository<QuestionnaireContactConfirm, String> {

    QuestionnaireContactConfirm getByQuestionnaireAndContact(Questionnaire questionnaire, Contact contact);

    QuestionnaireContactConfirm getByContactAndConfirmCode(Contact contact, String code);

    List<QuestionnaireContactConfirmDTO> findAllByQuestionnaire_UuidOrderByContact(String questionnaire_Uuid);
}
