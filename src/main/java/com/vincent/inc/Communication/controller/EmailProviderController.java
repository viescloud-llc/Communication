package com.vincent.inc.Communication.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.viescloud.llc.viesspringutils.controller.ViesController;
import com.vincent.inc.Communication.model.email.EmailProvider;
import com.vincent.inc.Communication.service.EmailProviderService;

@RestController
@RequestMapping("/email/providers")
public class EmailProviderController extends ViesController<Integer, EmailProvider, EmailProviderService> {

    public EmailProviderController(EmailProviderService service) {
        super(service);
    }
}
