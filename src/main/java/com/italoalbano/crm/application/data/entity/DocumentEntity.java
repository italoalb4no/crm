package com.italoalbano.crm.application.data.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;

import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "documents")
public class DocumentEntity {
    public static final int RADIX = 16;
    @Id
    @GenericGenerator(
            name = "uuid2",
            strategy = "uuid2")
    @Column(
            name = "id",
            updatable = false,
            nullable = false,
            columnDefinition = "VARCHAR(36)")
    private UUID id;
    @Column(name = "name")
    private String name;
    @Column(name = "mime_type")
    private String mimeType;
    @Column(name = "size")
    private long size = 0;
    @Column(name = "hash", nullable = false, unique = true)
    private String hash;
    @ManyToOne
    @JoinColumn(name = "item_id", nullable = false)
    private ItemEntity item;

    public UUID getId() {
        return this.id;
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

    public long getSize() {
        return this.size;
    }

    public void setSize(long size) {
        this.size = size;
    }

    public String getHash() {
        return this.hash;
    }

    public void setHash() throws NoSuchAlgorithmException {
        String transformedName = this.name + this.mimeType + this.size +
                new Date().getTime();
        MessageDigest messageDigest = MessageDigest.getInstance("MD5");
        messageDigest.update(transformedName.getBytes(StandardCharsets.UTF_8));
        this.hash = new BigInteger(1, messageDigest.digest()).toString(RADIX);
    }
}
