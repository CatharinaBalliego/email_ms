package com.ms.email.email.application.service;

import com.ms.email.email.application.api.EmailRequest;
import com.ms.email.email.application.api.EmailResponse;
import com.ms.email.email.application.repository.EmailRepository;
import com.ms.email.email.domain.Email;
import com.ms.email.email.domain.StatusEmail;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Log4j2
public class EmailApplicationService implements EmailService {
    private final EmailRepository emailRepository;
    private final JavaMailSender emailSender;


    @Override
    public EmailResponse sendEmail(EmailRequest emailRequest){
        log.info("[start] - EmailApplicationService - sendEmail");
        Email email = new Email(emailRequest);

        try {
            SimpleMailMessage message = new SimpleMailMessage();
            message.setFrom(email.getEmailFrom());
            message.setSubject(email.getSubject());
            message.setTo(email.getEmailTo());
            message.setText(email.getContent());
            emailSender.send(message);

            email.setStatusEmail(StatusEmail.SENT);
        } catch(MailException e) {
            email.setStatusEmail(StatusEmail.ERROR);
            log.info("Ocorreu um erro ao tentar enviar o email! ");
        } finally {
            return new EmailResponse(emailRepository.save(email));
        }

    }
}
