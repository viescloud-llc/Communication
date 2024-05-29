package com.vincent.inc.Communication.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vincent.inc.Communication.model.NtfyPackage;
import com.vincent.inc.Communication.model.NtfyPriorityEnum;
import com.vincent.inc.Communication.model.NtfyTagEnum;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;


@RestController
@RequestMapping("/ntfy")
public class NtfyController {
    
    @GetMapping("publish/{topic}")
    public NtfyPackage publish1(
        @PathVariable(value = "topic") String topic,
        @RequestHeader(required = false) String message,
        @RequestHeader(required = false) String title,
        @RequestHeader(required = false) List<NtfyTagEnum> tags,
        @RequestHeader(required = false) NtfyPriorityEnum priority,
        @RequestHeader(required = false) String click,
        @RequestHeader(required = false) String attach,
        @RequestHeader(required = false) boolean markdown,
        @RequestHeader(required = false) String icon,
        @RequestHeader(required = false) String filename,
        @RequestHeader(required = false) String delay,
        @RequestHeader(required = false) String email
        ) {
        var ntfyPackage = NtfyPackage.builder()
            .topic(topic)
            .message(message)
            .title(title)
            .tags(tags)
            .priority(priority)
            .click(click)
            .attach(attach)
            .markdown(markdown)
            .icon(icon)
            .filename(filename)
            .delay(delay)
            .email(email)
            .build();

        return ntfyPackage;
    }

    @PostMapping("publish")
    public NtfyPackage publish2(@RequestBody NtfyPackage ntfyPackage) {
        return ntfyPackage;
    }
    
}
