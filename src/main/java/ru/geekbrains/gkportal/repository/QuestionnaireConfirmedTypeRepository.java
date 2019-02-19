package ru.geekbrains.gkportal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.geekbrains.gkportal.entity.questionnaire.QuestionnaireConfirmedType;

@Repository
public interface QuestionnaireConfirmedTypeRepository extends JpaRepository<QuestionnaireConfirmedType, String> {

    QuestionnaireConfirmedType findByName(String name);

}
