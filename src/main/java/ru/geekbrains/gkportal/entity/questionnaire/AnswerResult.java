package ru.geekbrains.gkportal.entity.questionnaire;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import ru.geekbrains.gkportal.entity.AbstractEntity;
import ru.geekbrains.gkportal.entity.Contact;

import javax.persistence.*;
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
    @JoinColumn(name = "answer_id")
    @JsonIgnore
    private Answer answer;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "contact_id")
    @NotNull(message = "Contact s.b. selected!")
    private Contact contact;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "questionnaire_id")
    @NotNull(message = "Questionnaire s.b. selected!")
    private Questionnaire questionnaire;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "question_id")
    @NotNull(message = "Question s.b. selected!")
    private Question question;

}
