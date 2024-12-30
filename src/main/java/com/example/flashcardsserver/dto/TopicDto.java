package com.example.flashcardsserver.dto;

import com.example.flashcardsserver.enums.SubjectEnum;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Column;
import lombok.*;

import java.util.List;
import java.util.UUID;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TopicDto {
    @JsonProperty(required = true)
    private UUID id;
    @JsonProperty(required = true)
    private String title;

    @JsonProperty(required = true)
    private UUID authorId;

    @JsonProperty(required = true)
    private SubjectEnum subject;

    @JsonProperty(required = true)
    private Integer numberOfQuestions;

    @JsonProperty(required = true)
    private List<FlashcardDto> flashcards;
}
