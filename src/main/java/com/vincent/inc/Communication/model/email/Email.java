package com.vincent.inc.Communication.model.email;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Email {
    private EmailProvider emailProvider;
    private EmailMessage emailMessage;
}
