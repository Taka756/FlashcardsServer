package com.example.flashcardsserver.controllers;

import com.example.flashcardsserver.dto.QuizDto;
import com.example.flashcardsserver.services.QuizService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/quizzes")
public class QuizController {
    private final QuizService quizService;

    @GetMapping("/{topicId}")
    public QuizDto generateQuiz(@PathVariable UUID topicId){
        return quizService.generate(topicId);
    }
}
