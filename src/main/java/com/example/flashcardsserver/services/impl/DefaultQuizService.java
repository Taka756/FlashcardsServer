package com.example.flashcardsserver.services.impl;

import com.example.flashcardsserver.dto.QuizDto;
import com.example.flashcardsserver.entity.FlashcardEntity;
import com.example.flashcardsserver.entity.QuestionEntity;
import com.example.flashcardsserver.entity.QuizEntity;
import com.example.flashcardsserver.entity.TopicEntity;
import com.example.flashcardsserver.mapper.QuizMapper;
import com.example.flashcardsserver.repos.QuizRepository;
import com.example.flashcardsserver.services.QuizService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.web.server.Shutdown;
import org.springframework.stereotype.Service;

import java.util.*;


@Service
@RequiredArgsConstructor
@Slf4j
public class DefaultQuizService implements QuizService {
    private final QuizRepository quizRepository;
    private final DefaultTopicService topicService;
    @Override
    public QuizDto generate(UUID topicId) {
        TopicEntity topicEntity = topicService.findTopicById(topicId);
//        Set<FlashcardEntity> flashcardEntitySet = new HashSet<>(this.getUniqueFlashcardsByTerm(topicEntity.getFlashcards()));
        List<FlashcardEntity> flashcardEntityList = topicEntity.getFlashcards();

        QuizEntity quizEntity = new QuizEntity();
        Set<QuestionEntity> questionEntitySet = new HashSet<>();



        for (FlashcardEntity flashcardEntity : flashcardEntityList){
            QuestionEntity questionEntity = new QuestionEntity();

            questionEntity.setText(flashcardEntity.getTerm());
            questionEntity.setCorrectChoice(flashcardEntity.getDefinition());
            questionEntity.setQuiz(quizEntity);

            final String correctChoice = questionEntity.getCorrectChoice();
//            log.info("Corect choice: " + correctChoice);
            List<FlashcardEntity> shuffledFlashcards = new ArrayList<>(flashcardEntityList);
//            Collections.shuffle(shuffledFlashcards);
            Set<String> choicesSet = this.generateChoices(shuffledFlashcards, correctChoice);

            questionEntity.setChoices(choicesSet);

            questionEntitySet.add(questionEntity);
        }

        quizEntity.setTitle(topicEntity.getTitle());
        quizEntity.setQuestionEntities(questionEntitySet);

        QuizEntity savedQuiz = quizRepository.save(quizEntity);

        return QuizMapper.mapToDto(savedQuiz);
    }

    private List<FlashcardEntity> getUniqueFlashcardsByTerm(List<FlashcardEntity> flashcardEntitySet) {
        Map<String, FlashcardEntity> uniqueFlashcardsMap = new HashMap<>();

        for (FlashcardEntity flashcardEntity : flashcardEntitySet) {
            uniqueFlashcardsMap.putIfAbsent(flashcardEntity.getTerm(), flashcardEntity);
        }

        return new ArrayList<>(uniqueFlashcardsMap.values());
    }


    public Set<String> generateChoices(List<FlashcardEntity> flashcards, String correctChoice) {
        Set<String> choicesSet = new HashSet<>();
        choicesSet.add(correctChoice);

        for (FlashcardEntity flashcard : flashcards) {
            if (choicesSet.size() >= 4) break;

            String choice = flashcard.getDefinition();
            if (!correctChoice.equals(choice)) {
                choicesSet.add(choice);
            }
            Collections.shuffle(flashcards);
        }

        List<String> shuffledChoices = new ArrayList<>(choicesSet);
        Collections.shuffle(shuffledChoices);

        return new HashSet<>(shuffledChoices);
    }
}
