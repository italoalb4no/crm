package com.italoalbano.crm.application.dto;

import java.util.UUID;

public class DocumentDTO {

    private final long size = 0;
    private UUID id;
    private String name;
    private String mimeType;
    private String hash;

    public DocumentDTO() {
    }

    public long getSize() {
        return this.size;
    }

    public UUID getId() {
        return this.id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMimeType() {
        return this.mimeType;
    }

    public void setMimeType(String mimeType) {
        this.mimeType = mimeType;
    }

    public String getHash() {
        return this.hash;
    }

    public void setHash(String hash) {
        this.hash = hash;
    }
}
