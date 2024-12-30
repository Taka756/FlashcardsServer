package com.example.flashcardsserver.mapper;

import com.example.flashcardsserver.dto.FlashcardDto;
import com.example.flashcardsserver.dto.SaveFlashcardDto;
import com.example.flashcardsserver.entity.FlashcardEntity;
import com.example.flashcardsserver.entity.TopicEntity;
import lombok.experimental.UtilityClass;

@UtilityClass
public class FlashcardMapper {

    public FlashcardDto map(FlashcardEntity entity) {
        return FlashcardDto.builder()
                .id(entity.getId())
                .term(entity.getTerm())
                .definition(entity.getDefinition())
                .build();
    }

    public FlashcardEntity mapToEntity(SaveFlashcardDto dto, TopicEntity topicEntity){
        FlashcardEntity flashcard = new FlashcardEntity();
        flashcard.setTerm(dto.getTerm());
        flashcard.setDefinition(dto.getDefinition());
        flashcard.setTopic(topicEntity);
        return flashcard;
    }
}
