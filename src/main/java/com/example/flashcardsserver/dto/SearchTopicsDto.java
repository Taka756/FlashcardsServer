package com.example.flashcardsserver.dto;

import com.example.flashcardsserver.enums.SubjectEnum;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

import java.util.List;
import java.util.UUID;

@Builder
@Data
public class SearchTopicsDto {
    private String title;
    private UUID authorId;
    private List<SubjectEnum> subjects;
}
