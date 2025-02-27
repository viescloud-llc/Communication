package com.vincent.inc.Communication;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.time.Duration;

import org.junit.jupiter.api.Test;
import org.springframework.http.HttpMethod;
import org.springframework.web.client.RestTemplate;

import com.viescloud.llc.viesspringutils.util.WebCall;

public class CommunicationLiveTest {
    private static String dev_url = "http://10.24.24.101:1040";
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
                              .request(HttpMethod.GET, String.format("%s%s", dev_url, "/healthCheck"))
                              .logRequest()
                              .exchange()
                              .getResponseBody();

        assertNotNull(response);
        System.out.println(response);
    }
}
