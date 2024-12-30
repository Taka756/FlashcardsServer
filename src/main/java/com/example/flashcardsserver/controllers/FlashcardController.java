package com.example.flashcardsserver.controllers;

import com.example.flashcardsserver.dto.FlashcardDto;
import com.example.flashcardsserver.services.impl.DefaultFlashcardService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/flashcards")
public class FlashcardController {
    private final DefaultFlashcardService flashcardService;

//    @GetMapping("/save")
//    public String saveFlashcards(@RequestBody List<FlashcardDto> dtoList,){
//        flashcardService.saveAll();
//    }
    @DeleteMapping("/delete/{flashcardId}")
    public String delete(@PathVariable UUID flashcardId){
        flashcardService.delete(flashcardId);
        return "flashcard was deleted successfully";
    }
}
