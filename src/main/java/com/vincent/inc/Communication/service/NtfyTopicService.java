package com.vincent.inc.Communication.service;

import com.vincent.inc.Communication.dao.NtfyTopicDao;
import com.vincent.inc.Communication.model.ntfy.NtfyTopic;
import com.vincent.inc.viesspringutils.service.ViesService;
import com.vincent.inc.viesspringutils.util.DatabaseCall;

public class NtfyTopicService extends ViesService<NtfyTopic, Integer, NtfyTopicDao> {

    public NtfyTopicService(DatabaseCall<NtfyTopic, Integer> databaseCall, NtfyTopicDao repositoryDao) {
        super(databaseCall, repositoryDao);
    }

    @Override
    protected NtfyTopic newEmptyObject() {
        return new NtfyTopic();
    }
    
}
