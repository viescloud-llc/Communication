package com.vincent.inc.Communication.service;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;

import com.vincent.inc.Communication.model.email.Email;
import com.vincent.inc.Communication.model.email.EmailMessage;
import com.vincent.inc.Communication.model.email.EmailProvider;
import com.vincent.inc.Communication.util.Emails;

@Service
public class EmailService {
    private final ExecutorService executorService = Executors.newCachedThreadPool();

    public void sendEmail(EmailProvider emailProvider, SimpleMailMessage simpleMailMessage) {
        var emailSender = Emails.of(emailProvider);
        emailSender.send(simpleMailMessage);
    }

    public void sendEmail(EmailProvider emailProvider, EmailMessage emailMessage) {
        sendEmail(emailProvider, emailMessage.toSimpleMailMessage());
    }

    public void sendEmail(Email email) {
        this.sendEmail(email.getEmailProvider(), email.getEmailMessage());
    }

    public void sendEmailAsync(EmailProvider emailProvider, SimpleMailMessage simpleMailMessage) {
        executorService.submit(() -> this.sendEmail(emailProvider, simpleMailMessage));
    }

    public void sendEmailAsync(EmailProvider emailProvider, EmailMessage emailMessage) {
        executorService.submit(() -> this.sendEmail(emailProvider, emailMessage));
    }

    public void sendEmailAsync(Email email) {
        this.sendEmailAsync(email.getEmailProvider(), email.getEmailMessage());
    }

}
