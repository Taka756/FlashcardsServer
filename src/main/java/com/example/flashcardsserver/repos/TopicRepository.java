package com.example.flashcardsserver.repos;

import com.example.flashcardsserver.entity.TopicEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface TopicRepository extends JpaRepository<TopicEntity, UUID>, JpaSpecificationExecutor<TopicEntity> {
}
