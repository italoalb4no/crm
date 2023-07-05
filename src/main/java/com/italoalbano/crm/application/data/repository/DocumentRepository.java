package com.italoalbano.crm.application.data.repository;

import com.italoalbano.crm.application.data.entity.DocumentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface DocumentRepository extends JpaRepository<DocumentEntity, UUID> {
}
