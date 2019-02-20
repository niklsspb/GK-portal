package ru.geekbrains.gkportal.entity.questionnaire;


import lombok.*;
import ru.geekbrains.gkportal.entity.AbstractEntity;

import javax.persistence.Column;
import javax.persistence.Entity;

/**
 * @author Yuriy Tilman
 */

@Data
@Entity(name = "questionnaire_confirmed_type")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class QuestionnaireConfirmedType extends AbstractEntity {

    @Column(name = "name")
    private String name;

}
