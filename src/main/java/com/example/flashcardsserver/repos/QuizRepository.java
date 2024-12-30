package com.example.flashcardsserver.repos;

import com.example.flashcardsserver.entity.QuizEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface QuizRepository extends JpaRepository<QuizEntity, UUID> {
}
