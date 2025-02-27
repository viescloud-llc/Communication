package com.vincent.inc.Communication;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.time.Duration;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.http.HttpMethod;
import org.springframework.web.client.RestTemplate;

import com.viescloud.llc.viesspringutils.util.FSUtils;
import com.viescloud.llc.viesspringutils.util.Json;
import com.viescloud.llc.viesspringutils.util.WebCall;
import com.vincent.inc.Communication.model.email.Email;
import com.vincent.inc.Communication.model.email.EmailMessage;
import com.vincent.inc.Communication.model.email.EmailProvider;

public class CommunicationLiveTest {
    // private static String url = "http://10.24.24.101:1040";
    private static String url = "http://localhost:8089";
    private static RestTemplate restTemplate;
    static {
        try {
            restTemplate = com.viescloud.llc.viesspringutils.config.RestTemplateConfig.getRestTemplate(true, Duration.ofSeconds(15L), Duration.ofSeconds(15L));
        }
        catch(Exception e) {
            restTemplate = new RestTemplate();
        }
    }

    // @Test
    void healthCheck() {
        var response = WebCall.of(restTemplate, String.class)
                              .request(HttpMethod.GET, String.format("%s%s", url, "/healthCheck"))
                              .logRequest()
                              .exchange()
                              .getResponseBody();

        assertNotNull(response);
        System.out.println(response);
    }

    // @Test
    void testSendEmail() {
        EmailProvider emailProvider = new EmailProvider();
        emailProvider.setHost("smtp.gmail.com");
        emailProvider.setPort(587);
        emailProvider.setUsername("vincentbuiwork@gmail.com");
        emailProvider.setPassword(FSUtils.readFileAsString("temp/smtpPass.txt").map(e -> e.trim()).orElseThrow(() -> new RuntimeException("Cannot read password")));

        EmailMessage simpleMailMessage = new EmailMessage();
        simpleMailMessage.setFrom("no-reply <vincentbuiwork@gmail.com>");
        simpleMailMessage.setTo(List.of("vincentbuijunk@gmail.com"));
        simpleMailMessage.setSubject("Test from spring boot");
        simpleMailMessage.setText("Test from spring boot");

        Email email = new Email(emailProvider, simpleMailMessage);
        var json = Json.toJson(email);
        System.out.println(json);

        var response = WebCall.of(restTemplate, String.class)
                              .request(HttpMethod.POST, String.format("%s%s", url, "/email/senders"))
                              .header("content-type", "application/json")
                              .logRequest()
                              .body(email)
                              .exchange()
                              .logResponse()
                              .getResponseBody();

        assertNotNull(response);
        System.out.println(response);
    }
}
