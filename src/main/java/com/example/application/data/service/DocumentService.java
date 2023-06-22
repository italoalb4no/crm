package com.example.application.data.service;

import com.example.application.data.entity.DocumentEntity;
import com.example.application.data.repository.DocumentRepository;
import com.example.application.properties.DocumentStorageProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.NoSuchAlgorithmException;

@Service
public class DocumentService {
    private final Path docStorageLocation;
    @Autowired
    private DocumentRepository documentRepository;

    public DocumentService(DocumentStorageProperty documentStorageProperty) throws IOException {
        this.docStorageLocation = Paths
                .get(documentStorageProperty.getUploadDirectory())
                .toAbsolutePath()
                .normalize();
    }

    public DocumentEntity getDocumentById(Long id) {
        return this.documentRepository.getReferenceById(id);
    }

    @Transactional
    public void create(
            InputStream inputStream,
            String fileName,
            String contentType,
            Long size) throws NoSuchAlgorithmException, IOException {
        DocumentEntity document = new DocumentEntity();
        document.setName(fileName);
        document.setMimeType(contentType);
        document.setSize(size);
        document.setHash();
        storeDocument(inputStream, document.getHash());
        this.documentRepository.save(document);
    }

    private void storeDocument(InputStream inputStream, String hash) throws IOException {
        Path targetLocation = this.docStorageLocation.resolve(hash);
        Files.copy(inputStream, targetLocation);
    }
}
