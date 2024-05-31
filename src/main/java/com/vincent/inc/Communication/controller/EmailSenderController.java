package com.vincent.inc.Communication.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.vincent.inc.Communication.model.email.Email;
import com.vincent.inc.Communication.service.EmailService;

@RestController
@RequestMapping("/email-senders")
public class EmailSenderController {
    @Autowired
    private EmailService emailService;
    
    @PostMapping
    public Map<String, String> sendEmail(
        @RequestParam(required = false) boolean async,
        @RequestBody Email email
        ) {
        if (async) {
            emailService.sendEmailAsync(email);
        } else {
            emailService.sendEmail(email);
        }

        return Map.of("status", "sended");
    }
}
