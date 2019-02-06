package ru.geekbrains.gkportal.entity.questionnaire;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import ru.geekbrains.gkportal.entity.AbstractEntity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * @author Yuriy Tilman
 */

@Data
@Entity(name = "questionnaire_question_answer")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class QuestionnaireQuestionAnswer extends AbstractEntity {

    @Column(name = "name")
    @NotNull(message = "Couldn't be empty!")
    private String name;

    @Column(name = "sort_number")
    @NotNull(message = "Couldn't be empty!")
    private Integer sortNumber;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "questionnaire_question_answer_id")
    private List<QuestionnaireQuestionAnswerResult> qqAnswerResults;

    @ManyToOne
    @JoinColumn(name = "questionnaire_question_id")
    @JsonIgnore
    private QuestionnaireQuestion questionnaireQuestion;

    public QuestionnaireQuestionAnswer(@NotNull(message = "Couldn't be empty!") String name, @NotNull(message = "Couldn't be empty!") Integer sortNumber) {
        this.name = name;
        this.sortNumber = sortNumber;
    }

}