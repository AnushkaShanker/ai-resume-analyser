package com.resumeanalyser.service;


import org.springframework.stereotype.Service;

import com.resumeanalyser.entity.JobDescription;
import com.resumeanalyser.entity.User;
import com.resumeanalyser.repository.JobDescriptionRepository;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class JobDescriptionServiceImpl implements JobDescriptionService {

    private final JobDescriptionRepository jobDescriptionRepository;

    public JobDescriptionServiceImpl(JobDescriptionRepository jobDescriptionRepository) {
        this.jobDescriptionRepository = jobDescriptionRepository;
    }

    @Override
    public JobDescription saveJobDescription(User user, String jdText) {
        JobDescription jd = new JobDescription();
        jd.setUser(user);
        jd.setJdText(jdText);
        jd.setCreatedAt(LocalDateTime.now());

        return jobDescriptionRepository.save(jd);
    }

    @Override
    public List<JobDescription> getJobDescriptionsByUser(User user) {
        return jobDescriptionRepository.findByUser(user);
    }

	@Override
	public JobDescription getById(Long jdId) {
		// TODO Auto-generated method stub
		return null;
	}
}

