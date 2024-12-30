package com.example.flashcardsserver.services;

import com.example.flashcardsserver.dto.SaveTopicDto;
import com.example.flashcardsserver.dto.TopicDto;
import com.example.flashcardsserver.enums.NumberOfQuestionsEnum;
import com.example.flashcardsserver.enums.SubjectEnum;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.UUID;

public interface TopicService {
    Page<TopicDto> list(String title, UUID authorId, List<SubjectEnum> subject, NumberOfQuestionsEnum range, Pageable pageable);
    TopicDto get(UUID topicId);
    TopicDto save(SaveTopicDto dto);
    TopicDto edit(UUID topicId, SaveTopicDto dto);
    void delete(UUID topicId);
}
