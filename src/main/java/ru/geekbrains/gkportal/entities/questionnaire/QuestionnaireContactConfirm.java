package ru.geekbrains.gkportal.entities.questionnaire;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import ru.geekbrains.gkportal.entities.AbstractEntity;
import ru.geekbrains.gkportal.entities.Contact;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * @author Yuriy Tilman
 */

@Data
@Entity(name = "questionnaire_contact_confirm")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class QuestionnaireContactConfirm extends AbstractEntity {

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "questionnaire_id")
//    @NotNull(message = "Questionnaire s.b. selected!")
    private Questionnaire questionnaire;

    @Column(name = "confirm_code")
    private String confirmCode;

    @Column(name = "confirmed")
    @NotNull(message = "Couldn't be empty!")
    private boolean confirmed;

    @ManyToOne
    @JoinColumn(name = "contact_id")
    @NotNull(message = "Contact s.b. selected!")
    @JsonIgnore
    private Contact contact;

}
