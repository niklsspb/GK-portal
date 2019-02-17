package ru.geekbrains.gkportal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.geekbrains.gkportal.entity.questionnaire.Questionnaire;
import ru.geekbrains.gkportal.entity.questionnaire.QuestionnaireDTO;

@Repository
public interface QuestionnaireRepository extends JpaRepository<Questionnaire, String> {
    QuestionnaireDTO findByUuid(String uuid);
}
