package com.vincent.inc.Communication.util;

import java.util.Properties;

import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

import com.vincent.inc.Communication.model.email.EmailProvider;

public class Emails {
    private Emails() {}
    
    public static JavaMailSender of(EmailProvider emailProvider) {
        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
        mailSender.setHost(emailProvider.getHost());
        mailSender.setPort(emailProvider.getPort());
        mailSender.setUsername(emailProvider.getUsername());
        mailSender.setPassword(emailProvider.getPassword());

        Properties props = mailSender.getJavaMailProperties();
        props.put("mail.transport.protocol", emailProvider.getProtocol());
        props.put("mail.smtp.auth", emailProvider.isAuth());
        props.put("mail.smtp.starttls.enable", emailProvider.isStarttls());
        props.put("mail.smtp.starttls.required", emailProvider.isStarttls());
        
        return mailSender;
    }
}
