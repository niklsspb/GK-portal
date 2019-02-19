package ru.geekbrains.gkportal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.geekbrains.gkportal.dto.interfaces.AnswerResultDTO1;
import ru.geekbrains.gkportal.entity.Contact;
import ru.geekbrains.gkportal.entity.questionnaire.AnswerResult;

import java.util.List;
import java.util.Optional;

@Repository
public interface AnswerResultRepository extends JpaRepository<AnswerResult, String> {

    Optional<AnswerResult> findAllByContact(Contact contact);

    List<AnswerResultDTO1> findAllByQuestionnaire_UuidOrderByQuestion_SortNumber(String questionnaireUuid);

}
