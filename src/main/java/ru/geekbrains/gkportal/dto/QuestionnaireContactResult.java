package ru.geekbrains.gkportal.dto;

/**
 * @date 16.02.2019
 * @author Rinat
 */

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class QuestionnaireContactResult {

    private String firstNameContact;
    private String middleNameContact;
    private String lastNameContact;
    private String nameQuestionnaire;
    private String descriptionQuestionnaire;
    private boolean isOpenQuestionnaire;
    private String startDateQuestionnaire;
    private String endDateQuestionnaire;
    private boolean isActiveQuestionnaire;
    private boolean isInBuildNumQuestionnaire;
    private boolean isUseRealEstateQuestionnaire;
    private String nameQuestion;
    private String externalNumberQuestion;
    private int sortNumberQuestion;
    private String nameQuestionAnswer;
    private int sortNumberQuestionAnswer;
}
