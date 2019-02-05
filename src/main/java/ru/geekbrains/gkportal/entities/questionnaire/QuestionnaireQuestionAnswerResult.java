package ru.geekbrains.gkportal.entities.questionnaire;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import ru.geekbrains.gkportal.entities.AbstractEntity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 * @author Yuriy Tilman
 */

@Data
@Entity(name = "questionnaire_question_answer_result")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class QuestionnaireQuestionAnswerResult extends AbstractEntity {

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "questionnaire_question_answer_id")
    @JsonIgnore
    private QuestionnaireQuestionAnswer questionnaireQuestionAnswer;

}
