package com.vincent.inc.Communication.service;

import com.vincent.inc.Communication.dao.NtfyTopicDao;
import com.vincent.inc.Communication.model.ntfy.NtfyTopic;
import com.viescloud.llc.viesspringutils.repository.DatabaseCall;
import com.viescloud.llc.viesspringutils.service.ViesService;

public class NtfyTopicService extends ViesService<Integer, NtfyTopic, NtfyTopicDao> {

    public NtfyTopicService(DatabaseCall<Integer, NtfyTopic> databaseCall, NtfyTopicDao repositoryDao) {
        super(databaseCall, repositoryDao);
    }

    @Override
    public Integer getIdFieldValue(NtfyTopic object) {
        return object.getId();
    }
    
}
