package ru.geekbrains.gkportal.dto;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class QuestionResultFromView {
    //private String QuestionId;
    private String QuestionName;
    private List<AnswerFromViewDTO> answers = new ArrayList<>();

}
