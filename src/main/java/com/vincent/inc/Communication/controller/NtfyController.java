package com.vincent.inc.Communication.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vincent.inc.Communication.model.ntfy.NtfyAction;
import com.vincent.inc.Communication.model.ntfy.NtfyPackage;
import com.vincent.inc.Communication.model.ntfy.NtfyPriorityEnum;
import com.vincent.inc.Communication.model.ntfy.NtfyTagEnum;
import com.vincent.inc.Communication.model.ntfy.NtfyTopic;
import com.vincent.inc.Communication.service.NtfyService;
import com.vincent.inc.Communication.service.NtfyTopicService;
import com.viescloud.llc.viesspringutils.model.GenericPropertyMatcherEnum;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;


@RestController
@RequestMapping("/ntfy")
public class NtfyController {

    @Autowired
    private NtfyService ntfyService;

    @Autowired
    private NtfyTopicService ntfyTopicService;
    
    @GetMapping("publish/{topic}")
    public Object publish(
        @PathVariable(value = "topic") String topic,
        @RequestHeader(required = false) String title,
        @RequestHeader(required = false) NtfyPriorityEnum priority,
        @RequestHeader(required = false) String message,
        @RequestHeader(required = false) boolean markdown,
        @RequestHeader(required = false) List<NtfyTagEnum> tags,
        @RequestHeader(required = false) String attach,
        @RequestHeader(required = false) String filename,
        @RequestHeader(required = false) String click,
        @RequestHeader(required = false) String icon,
        @RequestHeader(required = false) List<NtfyAction> actions,
        @RequestHeader(required = false) String delay,
        @RequestHeader(required = false) String email
        ) {
        var ntfyPackage = NtfyPackage.builder()
            .topic(topic)
            .message(message)
            .title(title)
            .tags(tags)
            .priority(priority)
            .actions(actions)
            .click(click)
            .attach(attach)
            .markdown(markdown)
            .icon(icon)
            .filename(filename)
            .delay(delay)
            .email(email)
            .build();
        this.ntfyTopicService.getOrPostIfMatchAny(new NtfyTopic(0, topic), GenericPropertyMatcherEnum.CASE_SENSITIVE);
        return this.ntfyService.publish(ntfyPackage);
    }

    @PostMapping(value = "/publish", consumes = "application/json", produces = "application/json")
    public Object publish(@RequestBody NtfyPackage ntfyPackage) {
        this.ntfyTopicService.getOrPostIfMatchAny(new NtfyTopic(0, ntfyPackage.getTopic()), GenericPropertyMatcherEnum.CASE_SENSITIVE);
        return this.ntfyService.publish(ntfyPackage);
    }
    
}
