package com.vincent.inc.Communication.service;

import java.io.File;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.viescloud.llc.viesspringutils.exception.HttpResponseThrowers;
import com.viescloud.llc.viesspringutils.util.Streams;
import com.vincent.inc.Communication.model.email.Email;
import com.vincent.inc.Communication.model.email.EmailMessage;
import com.vincent.inc.Communication.model.email.EmailProvider;
import com.vincent.inc.Communication.util.Emails;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;

@Service
public class EmailService {

    private File newFile(String name, byte[] bytes) {
        try {
            var file = File.createTempFile(name, null);
            file.deleteOnExit();
            var out = new java.io.FileOutputStream(file);
            out.write(bytes);
            out.close();
            return file;
        }
        catch (Exception e) {
            return HttpResponseThrowers.throwServerError(e.getMessage());
        }
    }

    public void sendMimeEmail(EmailProvider emailProvider, SimpleMailMessage simpleMailMessage, boolean html, List<byte[]> attachments) {
        try {
            var emailSender = Emails.of(emailProvider);
            var mimeMessage = emailSender.createMimeMessage();

            if (simpleMailMessage.getFrom() != null) {
                mimeMessage.setFrom(new InternetAddress(simpleMailMessage.getFrom()));
            }
            else {
                HttpResponseThrowers.throwBadRequest("From is required");
            }

            if (simpleMailMessage.getReplyTo() != null) {
                mimeMessage.setReplyTo(new InternetAddress[] {new InternetAddress(simpleMailMessage.getReplyTo())});
            }

            if (simpleMailMessage.getTo() != null) {
                var to = Arrays.stream(Optional.ofNullable(simpleMailMessage.getTo()).orElse(new String[0]))
                                      .map(e -> Streams.doTry(() -> new InternetAddress(e), ex -> {HttpResponseThrowers.throwServerError(ex.getMessage());}))
                                      .toArray(InternetAddress[]::new);
                
                mimeMessage.setRecipients(MimeMessage.RecipientType.TO, to);
            }
            else {
                HttpResponseThrowers.throwBadRequest("To is required");
            }

            if (simpleMailMessage.getBcc() != null) {
                var bbc = Arrays.stream(Optional.ofNullable(simpleMailMessage.getBcc()).orElse(new String[0]))
                               .map(e -> Streams.doTry(() -> new InternetAddress(e), ex -> {HttpResponseThrowers.throwServerError(ex.getMessage());}))
                               .toArray(InternetAddress[]::new);
    
                mimeMessage.setRecipients(MimeMessage.RecipientType.BCC, bbc);
            }

            if (simpleMailMessage.getCc() != null) {
                var cc = Arrays.stream(Optional.ofNullable(simpleMailMessage.getCc()).orElse(new String[0]))
                               .map(e -> Streams.doTry(() -> new InternetAddress(e), ex -> {HttpResponseThrowers.throwServerError(ex.getMessage());}))
                               .toArray(InternetAddress[]::new);
    
                mimeMessage.setRecipients(MimeMessage.RecipientType.CC, cc);
            }

            if (simpleMailMessage.getSubject() != null) {
                mimeMessage.setSubject(simpleMailMessage.getSubject());
            }
            else {
                HttpResponseThrowers.throwBadRequest("Subject is required");
            }

            if (simpleMailMessage.getSentDate() != null) {
                mimeMessage.setSentDate(simpleMailMessage.getSentDate());
            }

            if (html) {
                mimeMessage.setContent(simpleMailMessage.getText(), "text/html; charset=utf-8");
            }
            else {
                mimeMessage.setText(simpleMailMessage.getText());
            }

            if (attachments != null && attachments.size() > 0) {
                MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);

                for (int i = 0; i < attachments.size(); i++) {
                    var attachment = attachments.get(i);
                    var name = String.format("%s-%s", "attachment", i);
                    var file = new FileSystemResource(newFile(name, attachment));
                    mimeMessageHelper.addAttachment(name, file);
                }
            }

            emailSender.send(mimeMessage);
        }
        catch (MessagingException ex) {
            HttpResponseThrowers.throwServerError(ex.getMessage());
        }
    }

    public void sendHtmlEmail(EmailProvider emailProvider, SimpleMailMessage emailMessage) {
        this.sendMimeEmail(emailProvider, emailMessage, true, null);
    }

    public void sendHtmlEmail(EmailProvider emailProvider, EmailMessage emailMessage) {
        this.sendHtmlEmail(emailProvider, emailMessage.toSimpleMailMessage());
    }

    public void sendHtmlEmail(Email email) {
        this.sendHtmlEmail(email.getEmailProvider(), email.getEmailMessage());
    }

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
}
