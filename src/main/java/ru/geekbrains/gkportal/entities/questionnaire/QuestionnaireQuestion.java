package ru.geekbrains.gkportal.entities.questionnaire;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import ru.geekbrains.gkportal.entities.AbstractEntity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * @author Yuriy Tilman
 */

@Data
@Entity(name = "questionnaire_question")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class QuestionnaireQuestion extends AbstractEntity {

    @Column(name = "name")
    @NotNull(message = "Couldn't be empty!")
    private String name;

    @Column(name = "sort_number")
    @NotNull(message = "Couldn't be empty!")
    private Integer sortNumber;


    @Column(name = "required")
    @NotNull(message = "Couldn't be empty!")
    private boolean required;

    @Column(name = "single")
    @NotNull(message = "Couldn't be empty!")
    private boolean single;

    @Column(name = "external_number")
    @NotNull(message = "Couldn't be empty!")
    private Integer externalNumber;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "questionnaire_question_id")
    private List<QuestionnaireQuestionAnswer> questionnaireQuestionAnswerList;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "questionnaire_id")
    @JsonIgnore
    private Questionnaire questionnaire;
}
