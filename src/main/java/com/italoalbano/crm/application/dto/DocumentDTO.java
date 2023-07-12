package com.italoalbano.crm.application.dto;

import java.io.InputStream;
import java.util.UUID;

public class DocumentDTO {

    private long size;
    private UUID id;
    private String name;
    private String mimeType;
    private String hash;
    private InputStream inputStream;

    public DocumentDTO() {
    }

    public long getSize() {
        return this.size;
    }

    public void setSize(long size) {
        this.size = size;
    }

    public DocumentDTO withSize(long size) {
        this.size = size;
        return this;
    }

    public UUID getId() {
        return this.id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public DocumentDTO withId(UUID id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public DocumentDTO withName(String name) {
        this.name = name;
        return this;
    }

    public String getMimeType() {
        return this.mimeType;
    }

    public void setMimeType(String mimeType) {
        this.mimeType = mimeType;
    }

    public DocumentDTO withMimeType(String mimeType) {
        this.mimeType = mimeType;
        return this;
    }

    public String getHash() {
        return this.hash;
    }

    public void setHash(String hash) {
        this.hash = hash;
    }

    public DocumentDTO withHash(String hash) {
        this.hash = hash;
        return this;
    }

    public InputStream getInputStream() {
        return this.inputStream;
    }

    public void setInputStream(InputStream inputStream) {
        this.inputStream = inputStream;
    }

    public DocumentDTO withInputStream(InputStream inputStream) {
        this.inputStream = inputStream;
        return this;
    }
}
