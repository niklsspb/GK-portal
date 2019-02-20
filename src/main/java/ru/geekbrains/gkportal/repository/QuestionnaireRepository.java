package ru.geekbrains.gkportal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ru.geekbrains.gkportal.dto.interfaces.QuestionnaireDTO;
import ru.geekbrains.gkportal.entity.questionnaire.Questionnaire;

@Repository
public interface QuestionnaireRepository extends JpaRepository<Questionnaire, String> {

    QuestionnaireDTO findByUuid(String uuid);

    @Query(
            value = "SELECT q.name FROM support_boot_db.questionnaire  q WHERE id = :uuid",
            nativeQuery = true
    )
    String findNameByUuid(@Param("uuid") String uuid);

}
