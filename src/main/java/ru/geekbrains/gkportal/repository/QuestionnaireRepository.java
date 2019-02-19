package ru.geekbrains.gkportal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.geekbrains.gkportal.entity.questionnaire.Questionnaire;

@Repository
public interface QuestionnaireRepository extends JpaRepository<Questionnaire, String> {
}
