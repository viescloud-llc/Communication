package com.vincent.inc.Communication.dao;

import org.springframework.stereotype.Repository;

import com.vincent.inc.Communication.model.email.EmailProvider;
import com.vincent.inc.viesspringutils.dao.ViesJpaRepository;

@Repository
public interface EmailProviderDao extends ViesJpaRepository<EmailProvider, Integer> {
    
}
