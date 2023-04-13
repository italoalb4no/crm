package com.example.application.data.entity;

import org.hibernate.validator.constraints.Length;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "items")
public class ItemEntity {

    @Id
    @GeneratedValue
    //(type = "uuid-char")
    private UUID id;
    @Column
    private LocalDate creationDate;
    @Column
    @Length(max = 30)
    private String name;
    @Column
    @Length(max = 500)
    private String description;

    public ItemEntity() {
    }

    public ItemEntity(UUID id, LocalDate creationDate, String name, String description) {
        this.id = id;
        this.creationDate = creationDate;
        this.name = name;
        this.description = description;
    }

    public ItemEntity(ItemEntity item) {
        this.id = item.id;
        this.creationDate = item.creationDate;
        this.name = item.name;
        this.description = item.description;
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
}
