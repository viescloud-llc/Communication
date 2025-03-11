package com.vincent.inc.Communication.controller;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.viescloud.llc.viesspringutils.exception.HttpResponseThrowers;
import com.vincent.inc.Communication.model.email.Email;
import com.vincent.inc.Communication.model.email.EmailMessage;
import com.vincent.inc.Communication.model.email.EmailProvider;
import com.vincent.inc.Communication.service.EmailProviderService;
import com.vincent.inc.Communication.service.EmailService;

import jakarta.annotation.PreDestroy;

@RestController
@RequestMapping("/email/senders")
public class EmailSenderController {
    @Autowired
    private EmailProviderService emailProviderService;

    @Autowired
    private EmailService emailService;

    private final ExecutorService executorService = Executors.newCachedThreadPool();
    private final String EMAIL_REGEX = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
    private final Pattern pattern = Pattern.compile(EMAIL_REGEX);

    @PreDestroy
    public void shutdown() {
        this.executorService.shutdown();
    }

    private void checkEmailAddress(String email) {
        if(!ObjectUtils.isEmpty(email) && !this.pattern.matcher(email).matches()) {
            HttpResponseThrowers.throwBadRequest("Invalid email address: " + email);
        }
    }

    private void checkEmailAddress(List<String> emails) {
        if (!ObjectUtils.isEmpty(emails)) {
            emails.forEach(e -> checkEmailAddress(e));
        }
    }

    private void sendEmail(EmailProvider provider, EmailMessage message, boolean async, boolean html) {
        checkEmailAddress(message.getReplyTo());
        checkEmailAddress(message.getTo());
        checkEmailAddress(message.getCc());
        checkEmailAddress(message.getBcc());

        if(async) {
            if(html) {
                this.executorService.submit(() -> this.emailService.sendHtmlEmail(provider, message));
            }
            else {
                this.executorService.submit(() -> this.emailService.sendEmail(provider, message));
            }
        }
        else {
            if(html) {
                this.emailService.sendHtmlEmail(provider, message);                
            }
            else {
                this.emailService.sendEmail(provider, message);
            }
        }
    }
    
    @PostMapping
    public Map<String, String> sendEmail(
        @RequestParam(required = false) boolean async, 
        @RequestParam(required = false) boolean html, 
        @RequestBody Email email
        ) {
        sendEmail(email.getEmailProvider(), email.getEmailMessage(), async, html);
        return Map.of("status", "sended");
    }

    @PostMapping("{providerId}")
    public Map<String, String> sendEmail(
        @PathVariable("providerId") int providerId, 
        @RequestParam(required = false) boolean async,
        @RequestParam(required = false) boolean html,
        @RequestBody EmailMessage message,
        @RequestHeader(value = "user_id", required = false, defaultValue = "0") String userId
        ) {
        var provider = this.emailProviderService.getById(providerId);
        this.emailProviderService.checkIsRelatedToUser(provider, userId);
        sendEmail(provider, message, async, html);
        return Map.of("status", "sended");
    }
}
