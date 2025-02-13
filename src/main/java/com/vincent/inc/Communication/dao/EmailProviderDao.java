package com.vincent.inc.Communication.dao;

import org.springframework.stereotype.Repository;

import com.viescloud.llc.viesspringutils.dao.ViesUserAccessJpaRepository;
import com.viescloud.llc.viesspringutils.dao.ViesUserAccessJpaRepositoryTemplate;
import com.vincent.inc.Communication.model.email.EmailProvider;

@Repository
public interface EmailProviderDao extends ViesUserAccessJpaRepository<EmailProvider, Integer> {
    
}

class EmailProviderDaoImpl extends ViesUserAccessJpaRepositoryTemplate<EmailProvider> {}