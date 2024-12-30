package com.example.flashcardsserver.entity;

import com.example.flashcardsserver.entity.common.BusinessEntity;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import lombok.Getter;
import lombok.Setter;
import java.util.UUID;

@Entity
@Table(name = "flashcards")
@Getter
@Setter
public class FlashcardEntity extends BusinessEntity {
    @Id
    @Column(name = "flashcard_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "term", nullable = false)
    private String term;

    @Column(name = "definition", nullable = false)
    private String definition;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "topic_id")
    @JsonBackReference
    private TopicEntity topic;
}
