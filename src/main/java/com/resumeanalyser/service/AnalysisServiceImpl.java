package com.resumeanalyser.service;

import org.springframework.stereotype.Service;

import com.resumeanalyser.entity.*;
import com.resumeanalyser.repository.AnalysisResultRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class AnalysisServiceImpl implements AnalysisService {

    private final AnalysisResultRepository analysisResultRepository;

    public AnalysisServiceImpl(AnalysisResultRepository analysisResultRepository) {
        this.analysisResultRepository = analysisResultRepository;
    }

    @Override
    public AnalysisResult analyzeResumeAgainstJD(Resume resume, JobDescription jobDescription) {

        Set<Skill> resumeSkills = resume.getSkills();
        Set<Skill> jdSkills = jobDescription.getRequiredSkills();

        List<Skill> matchedSkills = jdSkills.stream()
                .filter(resumeSkills::contains)
                .collect(Collectors.toList());

        List<Skill> missingSkills = jdSkills.stream()
                .filter(skill -> !resumeSkills.contains(skill))
                .collect(Collectors.toList());

        double atsScore = jdSkills.isEmpty()
                ? 0
                : ((double) matchedSkills.size() / jdSkills.size()) * 100;

        AnalysisResult result = new AnalysisResult();
        result.setResume(resume);
        result.setJobDescription(jobDescription);
        result.setAtsScore(atsScore);
        result.setCreatedAt(LocalDateTime.now());
        result.setMatchedSkills(matchedSkills);
        result.setMissingSkills(missingSkills);

        return analysisResultRepository.save(result);
    }
}

