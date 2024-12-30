package com.example.flashcardsserver.dto;

import com.example.flashcardsserver.entity.FlashcardEntity;
import com.example.flashcardsserver.enums.SubjectEnum;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SaveTopicDto {
    @JsonProperty(required = true)
    private String title;

    @JsonProperty(required = true)
    private UUID authorId;

    @JsonProperty(required = true)
    private SubjectEnum subject;

    @JsonProperty(required = true)
    private List<SaveFlashcardDto> flashcards;
}
