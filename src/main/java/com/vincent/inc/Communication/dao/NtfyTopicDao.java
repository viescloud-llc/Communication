package com.vincent.inc.Communication.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vincent.inc.Communication.model.ntfy.NtfyTopic;

@Repository
public interface NtfyTopicDao extends JpaRepository<NtfyTopic, Integer> {
    
}
