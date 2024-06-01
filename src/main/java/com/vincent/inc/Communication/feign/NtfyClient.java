package com.vincent.inc.Communication.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

import com.vincent.inc.Communication.model.ntfy.NtfyPackage;

@FeignClient(name = "Ntfy-client", url = "${ntfy.uri}")
public interface NtfyClient {
    
    @PostMapping(value = "/", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Object publish(@RequestHeader("Authorization") String basic, @RequestBody NtfyPackage ntfyPackage);
}
