package com.vincent.inc.Communication.service;

import org.springframework.stereotype.Service;

import com.vincent.inc.Communication.dao.EmailProviderDao;
import com.vincent.inc.Communication.model.email.EmailProvider;
import com.vincent.inc.viesspringutils.service.ViesService;
import com.vincent.inc.viesspringutils.util.DatabaseCall;

@Service
public class EmailProviderService extends ViesService<EmailProvider, Integer, EmailProviderDao> {

    public EmailProviderService(DatabaseCall<EmailProvider, Integer> databaseCall, EmailProviderDao repositoryDao) {
        super(databaseCall, repositoryDao);
    }

    @Override
    protected EmailProvider newEmptyObject() {
        return new EmailProvider();
    }
    
}
