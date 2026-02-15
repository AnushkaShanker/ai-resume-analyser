package com.resumeanalyser.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.resumeanalyser.entity.AnalysisResult;
import com.resumeanalyser.entity.JobDescription;
import com.resumeanalyser.entity.Resume;

import java.util.Optional;

public interface AnalysisResultRepository extends JpaRepository<AnalysisResult, Long> {

    Optional<AnalysisResult> findByResumeAndJobDescription(Resume resume, JobDescription jobDescription);
}