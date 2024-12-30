package com.example.flashcardsserver.repos;

import com.example.flashcardsserver.dto.FlashcardDto;
import com.example.flashcardsserver.entity.FlashcardEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface FlashcardRepository extends JpaRepository<FlashcardEntity, UUID> {
}
