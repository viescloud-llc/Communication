package com.vincent.inc.Communication.service;

import org.springframework.stereotype.Service;

import com.viescloud.llc.viesspringutils.repository.DatabaseCall;
import com.viescloud.llc.viesspringutils.service.ViesServiceWithUserAccess;
import com.vincent.inc.Communication.dao.EmailProviderDao;
import com.vincent.inc.Communication.model.email.EmailProvider;

@Service
public class EmailProviderService extends ViesServiceWithUserAccess<Integer, EmailProvider, EmailProviderDao> {

    public EmailProviderService(DatabaseCall<Integer, EmailProvider> databaseCall, EmailProviderDao repositoryDao) {
        super(databaseCall, repositoryDao);
    }

    @Override
    public Integer getIdFieldValue(EmailProvider object) {
        return object.getId();
    }
    
}
