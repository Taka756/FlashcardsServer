package com.example.flashcardsserver.entity;

import com.example.flashcardsserver.entity.common.BusinessEntity;
import com.example.flashcardsserver.enums.SubjectEnum;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "topics")
@Getter
@Setter
public class TopicEntity extends BusinessEntity {
    @Id
    @Column(name = "topic_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @Column(name = "title", nullable = false)
    private String title;
    @Column(name = "author_id", nullable = false)
    private UUID authorId;
    @Column(name = "subject", nullable = false)
    private SubjectEnum subject;
    @Column(name = "number_of_questions")
    private Integer numberOfQuestions;
    @OneToMany(mappedBy = "topic", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private List<FlashcardEntity> flashcards = new ArrayList<>();
}