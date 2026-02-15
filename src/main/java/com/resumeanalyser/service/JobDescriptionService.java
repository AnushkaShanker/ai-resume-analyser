package com.resumeanalyser.service;

import java.util.List;

import com.resumeanalyser.entity.JobDescription;
import com.resumeanalyser.entity.User;

public interface JobDescriptionService {

    JobDescription saveJobDescription(User user, String jdText);

    List<JobDescription> getJobDescriptionsByUser(User user);

	JobDescription getById(Long jdId);

}