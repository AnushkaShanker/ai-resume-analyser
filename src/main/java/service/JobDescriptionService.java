package service;

import entity.JobDescription;
import entity.User;

import java.util.List;

public interface JobDescriptionService {

    JobDescription saveJobDescription(User user, String jdText);

    List<JobDescription> getJobDescriptionsByUser(User user);
}