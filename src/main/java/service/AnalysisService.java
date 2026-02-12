package service;

import entity.AnalysisResult;
import entity.JobDescription;
import entity.Resume;

public interface AnalysisService {

    AnalysisResult analyzeResumeAgainstJD(Resume resume, JobDescription jobDescription);
}