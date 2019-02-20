package ru.geekbrains.gkportal.repository;

import org.hibernate.annotations.NamedNativeQuery;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ru.geekbrains.gkportal.dto.QuestionResultFromView;
import ru.geekbrains.gkportal.entity.questionnaire.Questionnaire;

import java.util.List;

@Repository
public interface QuestionnaireRepository extends JpaRepository<Questionnaire, String> {


    @Query(value = "SELECT * FROM questionnaire_result_view where questionnaire_id=:id", nativeQuery = true)
    List<QuestAns> getQuestionaryResultByQuestionaryId(@Param("id") String questionaryId);

    interface QuestAns{
        String getQuestion_name();
        String getAnswer_name();
        Integer getVote_count();
    }
}
