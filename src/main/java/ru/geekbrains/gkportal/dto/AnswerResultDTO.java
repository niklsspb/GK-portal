package ru.geekbrains.gkportal.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.geekbrains.gkportal.entity.AbstractEntity;
import ru.geekbrains.gkportal.entity.questionnaire.Answer;
import ru.geekbrains.gkportal.entity.questionnaire.Question;
import ru.geekbrains.gkportal.validation.ValidPhoneNumber;

import javax.persistence.Column;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@Getter
@Setter
@NoArgsConstructor
public class AnswerResultDTO {

    private Map<String, String> questionAnswerUuids = new HashMap<>();
    private Map<String, Answer> answers = new HashMap<>();
    private Map<String, Question> questions = new HashMap<>();
    private String questionnaireId;

    @NotNull(message = "Поле обязательно")
    @Size(min = 3, max = 255, message = "2-255 символов")
    private String fullName = "Тильман Юрий Александрович";

    @ValidPhoneNumber(message = "Телефон указан не корректно")
    @NotNull(message = "Поле обязательно")
    @Size(min = 10, message = "Минимум 10 символов")
    private String phoneNumber = "9104668422";

    @Email(message = "Почта указана не корректна")
    @NotNull(message = "Поле обязательно")
    @Size(min = 5, max = 25, message = "5-25 символов")
    private String email = "uatilman@gmail.com";

    @Column(name = "build_number")
    private Integer buildNumber = 555;

    @Column(name = "square")
    @NotNull(message = "Couldn't be empty!")
    private Double square;

    public AnswerResultDTO(Collection<Question> questions, String questionnaireId) {
        this.questionnaireId = questionnaireId;


        for (Question question : questions) {
            questionAnswerUuids.put(question.getUuid(), null);
            answers.putAll(question.getAnswers().stream().collect(Collectors.toMap(AbstractEntity::getUuid, Function.identity())));
        }
    }

//    public List<AnswerResult> toAnswerResults(Contact contact, Questionnaire questionnaire) {
//        Collection<Question> questions = questionnaire.getQuestions();
//        QuestionnaireContactConfirm questionnaireContactConfirm = QuestionnaireContactConfirm.builder()
//                .questionnaire(questionnaire)
//                .confirmCode(UUID.randomUUID().toString())
//                .contact(contact)
//                .build();
//        contact.setQuestionnaireContactConfirm(
//                questionnaireContactConfirm
//        );
//
//        for (Question question : questions) {
//            answers.putAll(question.getAnswers().stream().collect(Collectors.toMap(AbstractEntity::getUuid, Function.identity())));
//            this.questions.put(question.getUuid(), question);
//        }
//
//        List<AnswerResult> answerResults = new ArrayList<>();
//// TODO: 07.02.19 поиск списка ответов по id  иперенести в сервис
//        for (Map.Entry<String, String> entry : questionAnswerUuids.entrySet()) {
//            Answer answer = answers.get(entry.getValue());
//            answerResults.add(new AnswerResult(answer, contact));
//        }
////        questionAnswerUuids.forEach((s, s2) -> answerResults.add(new AnswerResult(answers.get(s), contact)));
//        return answerResults;
//    }


}
