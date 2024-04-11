package com.ms.email.email.application.api;

import com.ms.email.email.application.service.EmailService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@Log4j2
public class EmailController implements EmailApi {
    private final EmailService emailService;

    @Override
    public EmailResponse sendEmail(EmailRequest emailRequest) {
        log.info("[start] - EmailController - sendEmail");
        EmailResponse emailResponse = emailService.sendEmail(emailRequest);
        log.info("[finish] - EmailController - sendEmail");
        return emailResponse;
    }
}
