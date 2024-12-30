package com.example.flashcardsserver.services.impl;

import com.example.flashcardsserver.dto.SaveTopicDto;
import com.example.flashcardsserver.dto.TopicDto;
import com.example.flashcardsserver.entity.FlashcardEntity;
import com.example.flashcardsserver.entity.TopicEntity;
import com.example.flashcardsserver.enums.NumberOfQuestionsEnum;
import com.example.flashcardsserver.enums.SubjectEnum;
import com.example.flashcardsserver.exceptions.TopicNotFoundException;
import com.example.flashcardsserver.mapper.FlashcardMapper;
import com.example.flashcardsserver.mapper.TopicMapper;
import com.example.flashcardsserver.repos.TopicRepository;
import com.example.flashcardsserver.services.TopicService;
import com.example.flashcardsserver.specifications.TopicSpecifications;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.*;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class DefaultTopicService implements TopicService {
    private final TopicRepository topicRepository;

    @Override
    public Page<TopicDto> list(String title, UUID authorId, List<SubjectEnum> subject, NumberOfQuestionsEnum range, Pageable pageable) {
        Specification<TopicEntity> spec = Specification.where(TopicSpecifications.hasTitle(title))
                .and(TopicSpecifications.hasAuthorId(authorId))
                .and(TopicSpecifications.hasSubjects(subject))
                .and(TopicSpecifications.hasNumberOfQuestionsInRange(range));
        Page<TopicEntity> topics = topicRepository.findAll(spec, pageable);

        return topics.map(TopicMapper::mapToDto);
    }

    public TopicEntity findTopicById(UUID topicId){
        return topicRepository.findById(topicId).orElseThrow(() ->new TopicNotFoundException("Topic not found with Id " + topicId));
    }


    @Override
    public TopicDto get(UUID topicId) {
        TopicEntity topicEntity = findTopicById(topicId);
        return TopicMapper.mapToDto(topicEntity);
    }

    @Override
    public TopicDto save(SaveTopicDto dto) {
        TopicEntity topicEntity = TopicMapper.mapToEntity(dto);
        List<FlashcardEntity> flashcardEntities = dto.getFlashcards().stream().map(flashcardDto -> FlashcardMapper.mapToEntity(flashcardDto, topicEntity)).toList();

        topicEntity.setFlashcards(flashcardEntities);
        topicEntity.setNumberOfQuestions(flashcardEntities.size());
        TopicEntity fetchedTopic = topicRepository.save(topicEntity);
        return TopicMapper.mapToDto(fetchedTopic);
    }

    @Override
    public TopicDto edit(UUID topicId, SaveTopicDto dto) {
        TopicEntity oldTopicEntity = this.findTopicById(topicId);
        TopicEntity newTopicEntity = TopicMapper.mapToEntity(dto);
        List<FlashcardEntity> newFlashcardEntities = dto.getFlashcards().stream().map(flashcardDto -> FlashcardMapper.mapToEntity(flashcardDto, oldTopicEntity)).toList();

        oldTopicEntity.setTitle(newTopicEntity.getTitle());
        oldTopicEntity.setAuthorId(newTopicEntity.getAuthorId());
        oldTopicEntity.setSubject(newTopicEntity.getSubject());
        oldTopicEntity.getFlashcards().clear();
        oldTopicEntity.getFlashcards().addAll(newFlashcardEntities);
        oldTopicEntity.setNumberOfQuestions(newFlashcardEntities.size());
        TopicEntity fetchedTopic = topicRepository.save(oldTopicEntity);
        return TopicMapper.mapToDto(fetchedTopic);
    }

    @Override
    public void delete(UUID topicId) {
        TopicEntity topicEntity = findTopicById(topicId);
        topicRepository.delete(topicEntity);
    }

}
