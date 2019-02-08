package ru.geekbrains.gkportal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.geekbrains.gkportal.entity.questionnaire.AnswerResult;

@Repository
public interface AnswerResultRepository extends JpaRepository<AnswerResult, String> {

}
