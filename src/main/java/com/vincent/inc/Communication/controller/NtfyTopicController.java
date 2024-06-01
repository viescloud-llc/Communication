package com.vincent.inc.Communication.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vincent.inc.Communication.model.ntfy.NtfyTopic;
import com.vincent.inc.Communication.service.NtfyTopicService;
import com.vincent.inc.viesspringutils.controller.ViesController;

@RestController
@RequestMapping("/ntfy/topics")
public class NtfyTopicController extends ViesController<NtfyTopic, Integer, NtfyTopicService> {

    public NtfyTopicController(NtfyTopicService service) {
        super(service);
    }
}
