package ru.geekbrains.gkportal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.geekbrains.gkportal.dto.interfaces.AnswerResultDTO1;
import ru.geekbrains.gkportal.entity.questionnaire.AnswerResult;

import java.util.List;

@Repository
public interface AnswerResultRepository 
        extends JpaRepository<AnswerResult, String> {

    List<AnswerResult> findAllByContact_Uuid(String contactUuid);

    List<AnswerResultDTO1> findAllByQuestionnaire_UuidOrderByQuestion_SortNumber(String questionnaireUuid);

}
