package com.vincent.inc.Communication.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vincent.inc.Communication.model.ntfy.NtfyTopic;
import com.vincent.inc.Communication.service.NtfyTopicService;
import com.viescloud.llc.viesspringutils.controller.ViesController;

@RestController
@RequestMapping("/ntfy/topics")
public class NtfyTopicController extends ViesController<Integer, NtfyTopic, NtfyTopicService> {

    public NtfyTopicController(NtfyTopicService service) {
        super(service);
    }
}
