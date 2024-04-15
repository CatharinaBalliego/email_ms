package com.ms.email.email.application.api;

import com.ms.email.email.domain.Email;
import com.ms.email.email.domain.StatusEmail;
import jakarta.persistence.Column;
import lombok.Value;

import java.time.LocalDateTime;
import java.util.UUID;

@Value
public class EmailResponse {
    private UUID emailId;
    private String ownerRef;
    private String emailFrom;
    private String emailTo;
    private String subject;
    private String content;
    private LocalDateTime sendDateEmail;
    private StatusEmail statusEmail;


    public EmailResponse(Email email) {
        this.emailId = email.getEmailId();
        this.ownerRef = email.getOwnerRef();
        this.emailFrom = email.getEmailFrom();
        this.emailTo = email.getEmailTo();
        this.subject = email.getSubject();
        this.content = email.getContent();
        this.sendDateEmail = email.getSendDateEmail();
        this.statusEmail = email.getStatusEmail();
    }
}
