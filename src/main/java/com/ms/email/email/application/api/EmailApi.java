package com.ms.email.email.application.api;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

@RequestMapping(value = "/ms/v1/email")
public interface EmailApi {

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    EmailResponse sendEmail(@RequestBody @Valid EmailRequest emailRequest);
}
