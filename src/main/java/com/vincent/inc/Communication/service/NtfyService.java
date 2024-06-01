package com.vincent.inc.Communication.service;

import java.util.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import com.vincent.inc.Communication.feign.NtfyClient;
import com.vincent.inc.Communication.model.ntfy.NtfyPackage;

@Service
public class NtfyService {
    @Value("${ntfy.token}")
    private String ntfyToken;

    @Autowired
    private NtfyClient ntfyClient;

    public Object publish(NtfyPackage ntfyPackage) {
        var token = Base64.getEncoder().encodeToString((":" + ntfyToken).getBytes());
        return ntfyClient.publish(String .format("Basic %s", token), ntfyPackage);
    }
}
