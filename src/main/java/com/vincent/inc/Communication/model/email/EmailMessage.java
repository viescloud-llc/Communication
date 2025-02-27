package com.vincent.inc.Communication.model.email;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.mail.SimpleMailMessage;

import com.viescloud.llc.viesspringutils.util.DateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EmailMessage {
	private String from;
	private String replyTo;
	private List<String> to;
	private List<String> cc;
	private List<String> bcc;
	private DateTime sentDate;
	private String subject;
	private String text;

    public static EmailMessage from(SimpleMailMessage simpleMailMessage) {
        return EmailMessage.builder()
                .from(simpleMailMessage.getFrom())
                .replyTo(simpleMailMessage.getReplyTo())
                .to(new ArrayList<>(List.of(simpleMailMessage.getTo())))
                .cc(new ArrayList<>(List.of(simpleMailMessage.getCc())))
                .bcc(new ArrayList<>(List.of(simpleMailMessage.getBcc())))
                .sentDate(DateTime.of(simpleMailMessage.getSentDate()))
                .subject(simpleMailMessage.getSubject())
                .text(simpleMailMessage.getText())
                .build();
    }

    public SimpleMailMessage toSimpleMailMessage() {
        var to = Optional.ofNullable(this.to).map(e -> e.toArray(new String[0])).orElse(null);
        var cc = Optional.ofNullable(this.cc).map(e -> e.toArray(new String[0])).orElse(null);
        var bcc = Optional.ofNullable(this.bcc).map(e -> e.toArray(new String[0])).orElse(null);
        var sendDate = Optional.ofNullable(this.sentDate).map(e -> e.toDate()).orElse(null);

        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setFrom(this.from);
        simpleMailMessage.setReplyTo(this.replyTo);
        simpleMailMessage.setTo(to);
        simpleMailMessage.setCc(cc);
        simpleMailMessage.setBcc(bcc);
        simpleMailMessage.setSentDate(sendDate);
        simpleMailMessage.setSubject(this.subject);
        simpleMailMessage.setText(this.text);
        return simpleMailMessage;
    }
}
