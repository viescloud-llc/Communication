package com.vincent.inc.Communication.controller;

import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.vincent.inc.Communication.model.email.Email;
import com.vincent.inc.Communication.model.email.EmailMessage;
import com.vincent.inc.Communication.service.EmailProviderService;
import com.vincent.inc.Communication.service.EmailService;

@RestController
@RequestMapping("/email/senders")
public class EmailSenderController {
    @Autowired
    private EmailProviderService emailProviderService;

    @Autowired
    private EmailService emailService;
    
    @PostMapping
    public Map<String, String> sendEmail(
        @RequestParam(required = false) boolean async,
        @RequestBody Email email
        ) {
        if (Optional.ofNullable(async).orElse(false)) {
            emailService.sendEmailAsync(email);
        } else {
            emailService.sendEmail(email);
        }

        return Map.of("status", "sended");
    }

    @PostMapping("{providerId}")
    public Map<String, String> sendEmail(
        @PathVariable("providerId") int providerId, 
        @RequestParam(required = false) boolean async,
        @RequestBody EmailMessage message,
        @RequestHeader(value = "user_id", required = false, defaultValue = "0") String userId
        ) {
        var provider = this.emailProviderService.getById(providerId);
        this.emailProviderService.checkIsRelatedToUser(provider, userId);

        if (Optional.ofNullable(async).orElse(false)) {
            emailService.sendEmailAsync(provider, message);
        } else {
            emailService.sendEmail(provider, message);
        }

        return Map.of("status", "sended");
    }
}
