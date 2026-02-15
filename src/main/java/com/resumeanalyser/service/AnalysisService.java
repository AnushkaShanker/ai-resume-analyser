package com.resumeanalyser.service;

import com.resumeanalyser.entity.AnalysisResult;
import com.resumeanalyser.entity.JobDescription;
import com.resumeanalyser.entity.Resume;

public interface AnalysisService {

    AnalysisResult analyzeResumeAgainstJD(Resume resume, JobDescription jobDescription);
}