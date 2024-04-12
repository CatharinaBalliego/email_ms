package com.ms.email.email.domain;

import com.ms.email.email.application.api.EmailRequest;
import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Entity
@Table(name = "email_tb")
public class Email implements Serializable {

    public Email(EmailRequest emailRequest) {
        this.ownerRef = emailRequest.getOwnerRef();
        this.emailFrom = emailRequest.getEmailFrom();
        this.emailTo = emailRequest.getEmailTo();
        this.subject = emailRequest.getSubject();
        this.content = emailRequest.getContent();
        this.sendDateEmail = LocalDateTime.now();

    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID emailId;
    private String ownerRef;
    private String emailFrom;
    private String emailTo;
    private String subject;
    @Column(columnDefinition = "TEXT")
    private String content;
    private LocalDateTime sendDateEmail;
    private StatusEmail statusEmail;



}
