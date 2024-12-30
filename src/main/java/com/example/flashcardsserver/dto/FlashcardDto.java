package com.example.flashcardsserver.dto;

import com.example.flashcardsserver.entity.TopicEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

import java.util.UUID;

@Builder
@Data
public class FlashcardDto {
    @JsonProperty(required = true)
    private UUID id;
    @JsonProperty(required = true)
    private String term;
    @JsonProperty(required = true)
    private String definition;
    @JsonIgnore
    private TopicEntity topic;
}
