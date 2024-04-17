package com.ms.email.email.consumer;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ms.email.email.application.api.EmailRequest;
import com.ms.email.email.application.api.EmailResponse;
import com.ms.email.email.application.service.EmailService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Log4j2
public class EmailConsumer {
    @Autowired
    private EmailService emailService;

    @RabbitListener(queues = "${spring.rabbitmq.queue}")
    public void listen(String message) throws JsonProcessingException {
        log.info("[start] EmailConsumer");
        EmailRequest emailRequest = new ObjectMapper().readValue(message, EmailRequest.class);
        EmailResponse emailResponse = emailService.sendEmail(emailRequest);
        log.info("Email status: " + emailResponse.getStatusEmail());
    }
}
