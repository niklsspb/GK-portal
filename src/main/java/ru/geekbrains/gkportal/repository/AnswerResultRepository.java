package ru.geekbrains.gkportal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.geekbrains.gkportal.entity.Contact;
import ru.geekbrains.gkportal.entity.questionnaire.AnswerResult;

import java.util.Optional;

@Repository
public interface AnswerResultRepository extends CrudRepository<AnswerResult, String>, JpaRepository<AnswerResult, String> {
    Optional<AnswerResult> findAllByContact(Contact contact);
}
