package com.example.application.data.entity;

import jakarta.persistence.*;
import org.hibernate.validator.constraints.Length;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "items")
public class ItemEntity {

    @Id
    @GeneratedValue
    private UUID id;
    @Column
    private LocalDate creationDate;
    @Column
    @Length(max = 30)
    private String name;
    @Column
    @Length(max = 500)
    private String description;
    @Column
    private List<DocumentEntity> attachment;

    public ItemEntity() {
    }

    public UUID getId() {
        return this.id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public LocalDate getCreationDate() {
        return this.creationDate;
    }

    public void setCreationDate(LocalDate creationDate) {
        this.creationDate = creationDate;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<DocumentEntity> getAttachment() {
        return this.attachment;
    }

    public void setAttachment(List<DocumentEntity> attachment) {
        this.attachment = attachment;
    }
}