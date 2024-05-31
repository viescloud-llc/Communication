package com.vincent.inc.Communication.model.email;

import org.springframework.mail.SimpleMailMessage;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Email {
    private EmailProvider emailProvider;
    private SimpleMailMessage simpleMailMessage;
}
