package com.example.flashcardsserver.services.impl;

import com.example.flashcardsserver.dto.FlashcardDto;
import com.example.flashcardsserver.entity.FlashcardEntity;
import com.example.flashcardsserver.entity.TopicEntity;
import com.example.flashcardsserver.repos.FlashcardRepository;
import com.example.flashcardsserver.services.FlashcardService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class DefaultFlashcardService implements FlashcardService {
    private final FlashcardRepository flashcardRepository;
    @Override
    public List<FlashcardEntity> saveAll(List<FlashcardDto> dtos, TopicEntity topicEntity)
    {
        return dtos.stream().map(dto -> {
            FlashcardEntity flashcardEntity = new FlashcardEntity();
            flashcardEntity.setTerm(dto.getTerm());
            flashcardEntity.setDefinition(dto.getDefinition());
            flashcardEntity.setTopic(topicEntity);
            return flashcardEntity;
        }).toList();
//        flashcardRepository.saveAll(flashcardEntities);
    }

    @Override
    public void delete(UUID flashcardId) {
        flashcardRepository.deleteById(flashcardId);
    }
}
