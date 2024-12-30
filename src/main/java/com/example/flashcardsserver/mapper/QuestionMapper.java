package com.example.flashcardsserver.mapper;

import com.example.flashcardsserver.dto.QuestionDto;
import com.example.flashcardsserver.entity.QuestionEntity;
import com.example.flashcardsserver.entity.QuizEntity;
import lombok.experimental.UtilityClass;

@UtilityClass
public class QuestionMapper {
    public QuestionDto mapToDto(QuestionEntity questionEntity, QuizEntity quizEntity){
        return QuestionDto.builder()
                .id(questionEntity.getId())
                .text(questionEntity.getText())
                .correctChoice(questionEntity.getCorrectChoice())
                .choices(questionEntity.getChoices())
                .quiz(quizEntity)
                .build();
    }
}
