package com.example.flashcardsserver.services;

import com.example.flashcardsserver.dto.FlashcardDto;
import com.example.flashcardsserver.entity.FlashcardEntity;
import com.example.flashcardsserver.entity.TopicEntity;

import java.util.List;
import java.util.UUID;

public interface FlashcardService {
    List<FlashcardEntity> saveAll(List<FlashcardDto> flashcardDtos, TopicEntity topicEntity);

    void delete(UUID flashcardId);
}
