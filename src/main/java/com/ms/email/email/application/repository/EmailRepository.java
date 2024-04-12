package com.ms.email.email.application.repository;

import com.ms.email.email.domain.Email;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface EmailRepository extends JpaRepository<Email, UUID> {
}
