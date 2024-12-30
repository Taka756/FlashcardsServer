package com.example.flashcardsserver.dto;

import com.example.flashcardsserver.entity.QuizEntity;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Builder
@Data
public class QuestionDto {
    @JsonProperty(required = true)
    private UUID id;
    @JsonProperty(required = true)
    private String text;
    @JsonProperty(required = true)
    private String correctChoice;
    @JsonProperty(required = true)
    private Set<String> choices;
    @JsonIgnore
    private QuizEntity quiz;
}
