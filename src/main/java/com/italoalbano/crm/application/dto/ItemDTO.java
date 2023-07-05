package com.italoalbano.crm.application.dto;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

public class ItemDTO {

    private UUID id;
    private LocalDate creationDate;
    private String name;
    private String description;
    private List<DocumentDTO> documents;

    public ItemDTO() {
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

    public List<DocumentDTO> getDocuments() {
        return this.documents;
    }

    public void setDocuments(List<DocumentDTO> documents) {
        this.documents = documents;
    }
}
