package com.example.flashcardsserver.dto;

import com.example.flashcardsserver.entity.QuestionEntity;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.OneToMany;
import lombok.Builder;
import lombok.Data;

import java.util.Set;
import java.util.UUID;

@Builder
@Data
public class QuizDto {
    @JsonProperty(required = true)
    private UUID id;
    @JsonProperty(required = true)
    private String title;
    @JsonProperty(required = true)
    private Set<QuestionDto> questionEntities;
}
