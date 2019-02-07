package ru.geekbrains.gkportal.entity.questionnaire;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import ru.geekbrains.gkportal.entity.AbstractEntity;
import ru.geekbrains.gkportal.entity.Contact;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

/**
 * @author Yuriy Tilman
 */


@Entity(name = "questionnaire_question_answer_result")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class AnswerResult extends AbstractEntity {

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "questionnaire_question_answer_id")
    @JsonIgnore
    private Answer answer;

    @ManyToOne
    @JoinColumn(name = "contact_id")
    @NotNull(message = "Contact s.b. selected!")
    private Contact contact;


}
