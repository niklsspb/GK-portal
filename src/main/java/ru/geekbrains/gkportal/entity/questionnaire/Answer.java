package ru.geekbrains.gkportal.entity.questionnaire;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.apache.log4j.Logger;
import ru.geekbrains.gkportal.GkPortalApplication;
import ru.geekbrains.gkportal.entity.AbstractEntity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Yuriy Tilman
 */

@Entity(name = "questionnaire_question_answer")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Answer extends AbstractEntity {

    private static final Logger logger = Logger.getLogger(GkPortalApplication.class);

    @Column(name = "name")
    @NotNull(message = "Couldn't be empty!")
    private String name;

    @Column(name = "sort_number")
    @NotNull(message = "Couldn't be empty!")
    private Integer sortNumber;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "answer_id")
    private List<AnswerResult> answerResults = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "questionnaire_question_id")
    @JsonIgnore
    private Question question;

    public Answer(@NotNull(message = "Couldn't be empty!") String name, @NotNull(message = "Couldn't be empty!") Integer sortNumber) {
        this.name = name;
        this.sortNumber = sortNumber;
    }


}