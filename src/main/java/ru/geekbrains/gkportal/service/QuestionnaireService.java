package ru.geekbrains.gkportal.service;


import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.geekbrains.gkportal.dto.SystemAccountToOwnerShip;
import ru.geekbrains.gkportal.dto.interfaces.QuestionnaireContactConfirmDTO;
import ru.geekbrains.gkportal.dto.interfaces.QuestionnaireDTO;
import ru.geekbrains.gkportal.entity.Contact;
import ru.geekbrains.gkportal.entity.questionnaire.*;
import ru.geekbrains.gkportal.exception.QuestionnaireContactConfirmNotFoundException;
import ru.geekbrains.gkportal.repository.QuestionnaireConfirmedTypeRepository;
import ru.geekbrains.gkportal.repository.QuestionnaireContactConfirmRepository;
import ru.geekbrains.gkportal.repository.QuestionnaireRepository;

import java.util.Comparator;
import java.util.List;
import java.util.function.Supplier;

@Service
public class QuestionnaireService {

    private static final Logger logger = Logger.getLogger(QuestionnaireService.class);

    private QuestionnaireRepository questionnaireRepository;
    private QuestionnaireContactConfirmRepository questionnaireContactConfirmRepository;
    private QuestionnaireConfirmedTypeRepository questionnaireConfirmedTypeRepository;
    private MailService mailService;

    @Autowired
    public void setMailService(MailService mailService) {
        this.mailService = mailService;
    }

    @Autowired
    public void setQuestionnaireContactConfirmRepository(QuestionnaireContactConfirmRepository questionnaireContactConfirmRepository) {
        this.questionnaireContactConfirmRepository = questionnaireContactConfirmRepository;
    }

    @Autowired
    public void setQuestionnaireRepository(QuestionnaireRepository questionnaireRepository) {
        this.questionnaireRepository = questionnaireRepository;
    }

    @Autowired
    public void setQuestionnaireConfirmedTypeRepository(QuestionnaireConfirmedTypeRepository questionnaireConfirmedTypeRepository) {
        this.questionnaireConfirmedTypeRepository = questionnaireConfirmedTypeRepository;
    }

    public Questionnaire findByIdAndSortAnswers(String id) {
        Questionnaire questionnaire = findById(id);

        if (questionnaire != null) {
            questionnaire.getQuestions().forEach(questionnaireQuestion ->
                    questionnaireQuestion.getAnswers()
                            .sort(Comparator.comparingInt(Answer::getSortNumber)));
        }
        return questionnaire;
    }

    public Questionnaire findByIdAndSortQuestionsAndAnswers(String id) {
        Questionnaire questionnaire = findByIdAndSortAnswers(id);
        questionnaire.getQuestions().sort(Comparator.comparingInt(Question::getSortNumber));
        return questionnaire;
    }

    public QuestionnaireConfirmedType findQuestionnaireConfirmedTypeByName(String name) {
        return questionnaireConfirmedTypeRepository.findByName(name);
    }

    public QuestionnaireDTO findQuestionnaireDTOById(String uuid) {
        return questionnaireRepository.findByUuid(uuid);
    }

    public Questionnaire findById(String id) {
        return questionnaireRepository.findById(id).orElse(null);
    }

    public Questionnaire save(Questionnaire questionnaire) {
        return questionnaireRepository.save(questionnaire);
    }

    public boolean isQuestionnaireContactExist(Questionnaire questionnaire, Contact contact) {
        return (questionnaireContactConfirmRepository.getByQuestionnaireAndContact(questionnaire, contact) != null);
    }

    public List<Questionnaire> findAll() {
        return questionnaireRepository.findAll();
    }

    public void sendMail(SystemAccountToOwnerShip systemAccount, Contact contact) {
    }

    public QuestionnaireContactConfirm getQuestionnaireContactConfirm(String questionnaireId, Contact contact) {
        return questionnaireContactConfirmRepository.getByQuestionnaireAndContact(findById(questionnaireId), contact);
    }

    public List<QuestionnaireContactConfirmDTO> findQuestionnaireContactConfirmDTO(String questionnaireId) {
        return questionnaireContactConfirmRepository.findAllByQuestionnaire_UuidOrderByContact(questionnaireId);
    }

    public QuestionnaireContactConfirm changeQuestionnaireConfirmedType(String questionnaireContactConfirmId, String questionnaireConfirmedTypeId) throws Throwable {

        QuestionnaireContactConfirm questionnaireContactConfirm = questionnaireContactConfirmRepository
                .findById(questionnaireContactConfirmId)
                .orElseThrow((Supplier<Throwable>) () -> new QuestionnaireContactConfirmNotFoundException(questionnaireContactConfirmId));

        QuestionnaireConfirmedType questionnaireConfirmedType = questionnaireConfirmedTypeRepository
                .findById(questionnaireConfirmedTypeId)
                .orElseThrow((Supplier<Throwable>) () -> new QuestionnaireContactConfirmNotFoundException(questionnaireContactConfirmId));

        questionnaireContactConfirm.setQuestionnaireConfirmedType(questionnaireConfirmedType);

        return questionnaireContactConfirmRepository.save(questionnaireContactConfirm);


    }

    public boolean confirmQuetionnaire(Contact contact, String code) {
        QuestionnaireContactConfirm confirm = questionnaireContactConfirmRepository.getByContactAndConfirmCode(contact, code);
        if (confirm != null) {
            confirm.setConfirmed(true);
            questionnaireContactConfirmRepository.save(confirm);
            return true;
        }
        return false;
    }
}
