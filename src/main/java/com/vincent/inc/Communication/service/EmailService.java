package com.vincent.inc.Communication.service;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;

import com.vincent.inc.Communication.model.email.Email;
import com.vincent.inc.Communication.model.email.EmailProvider;
import com.vincent.inc.Communication.util.Emails;

@Service
public class EmailService {
    private final ExecutorService executorService = Executors.newCachedThreadPool();

    public void sendEmail(EmailProvider emailProvider, SimpleMailMessage simpleMailMessage) {
        var emailSender = Emails.of(emailProvider);
        emailSender.send(simpleMailMessage);
    }

    public void sendEmail(Email email) {
        this.sendEmail(email.getEmailProvider(), email.getSimpleMailMessage());
    }

    public void sendEmailAsync(EmailProvider emailProvider, SimpleMailMessage simpleMailMessage) {
        executorService.submit(() -> this.sendEmailAsync(emailProvider, simpleMailMessage));
    }

    public void sendEmailAsync(Email email) {
        this.sendEmailAsync(email.getEmailProvider(), email.getSimpleMailMessage());
    }

}
