package com.ms.email.email.application.service;

import com.ms.email.email.application.api.EmailRequest;
import com.ms.email.email.application.api.EmailResponse;

public interface EmailService {

    EmailResponse sendEmail(EmailRequest emailRequest);
}
