package com.example.flashcardsserver.mapper;

import com.example.flashcardsserver.dto.FlashcardDto;
import com.example.flashcardsserver.dto.QuestionDto;
import com.example.flashcardsserver.dto.QuizDto;
import com.example.flashcardsserver.entity.QuestionEntity;
import com.example.flashcardsserver.entity.QuizEntity;
import lombok.experimental.UtilityClass;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@UtilityClass
public class QuizMapper {

    public QuizDto mapToDto(QuizEntity quizEntity){
        Set<QuestionDto> questionDTOs = quizEntity.getQuestionEntities().stream()
                .map(questionEntity -> QuestionMapper.mapToDto(questionEntity, quizEntity))
                .collect(Collectors.toSet());
        return QuizDto.builder()
                .id(quizEntity.getId())
                .title(quizEntity.getTitle())
                .questionEntities(questionDTOs)
                .build();
    }
}
