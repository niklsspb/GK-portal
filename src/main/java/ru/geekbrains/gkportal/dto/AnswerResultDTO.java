package ru.geekbrains.gkportal.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.apache.log4j.Logger;
import ru.geekbrains.gkportal.entity.AbstractEntity;
import ru.geekbrains.gkportal.entity.questionnaire.Answer;
import ru.geekbrains.gkportal.entity.questionnaire.Question;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@Getter
@Setter
@NoArgsConstructor
public class AnswerResultDTO {

    private static final Logger logger = Logger.getLogger(AnswerResultDTO.class);

    private Map<String, String> questionAnswerUuids = new HashMap<>();
    private Map<String, Answer> answers = new HashMap<>();
    private Map<String, Question> questions = new HashMap<>();
    private String questionnaireId;

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
