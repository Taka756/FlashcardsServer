package com.example.flashcardsserver.mapper;

import com.example.flashcardsserver.dto.FlashcardDto;
import com.example.flashcardsserver.dto.SaveTopicDto;
import com.example.flashcardsserver.dto.TopicDto;
import com.example.flashcardsserver.entity.TopicEntity;
import lombok.experimental.UtilityClass;
import java.util.List;

@UtilityClass
public class TopicMapper {
    public TopicDto mapToDto(TopicEntity entity){
        List<FlashcardDto> flashcardDtos = entity.getFlashcards().stream()
                .map(FlashcardMapper::map)
                .toList();
        return TopicDto.builder()
                .id(entity.getId())
                .title(entity.getTitle())
                .authorId(entity.getAuthorId())
                .subject(entity.getSubject())
                .numberOfQuestions(entity.getNumberOfQuestions())
                .flashcards(flashcardDtos)
                .build();
    }

    public TopicEntity mapToEntity(SaveTopicDto dto){
        TopicEntity entity = new TopicEntity();
        entity.setTitle(dto.getTitle());
        entity.setAuthorId(dto.getAuthorId());
        entity.setSubject(dto.getSubject());
        return entity;
    }
}
