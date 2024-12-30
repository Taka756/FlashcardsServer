package com.example.flashcardsserver.dto;

import com.example.flashcardsserver.entity.TopicEntity;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class SaveFlashcardDto {
    @JsonProperty(required = true)
    private String term;
    @JsonProperty(required = true)
    private String definition;
}
