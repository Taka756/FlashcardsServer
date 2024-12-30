package com.example.flashcardsserver.services;

import com.example.flashcardsserver.dto.QuizDto;
import com.example.flashcardsserver.entity.QuizEntity;
import com.example.flashcardsserver.entity.TopicEntity;

import java.util.UUID;

public interface QuizService {
    QuizDto generate(UUID topicId);
}
