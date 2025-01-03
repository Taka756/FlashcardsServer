package com.example.flashcardsserver.entity.common;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.TimeZone;

@Getter
@Setter
@MappedSuperclass
public class BusinessEntity {
    @Column(name = "created_date", nullable = false)
    private LocalDateTime creationDate;
    @Column(name = "last_updated_date", nullable = false)
    private LocalDateTime lastUpdateDate;

    @PrePersist
    public void prePersist() {
        this.creationDate = LocalDateTime.now(TimeZone.getDefault().toZoneId());
        this.lastUpdateDate = this.creationDate;
    }

    @PreUpdate
    public void preUpdate() {
        this.lastUpdateDate = LocalDateTime.now(TimeZone.getDefault().toZoneId());
    }
}
