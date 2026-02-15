package com.resumeanalyser.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.resumeanalyser.dto.AnalysisResponseDTO;
import com.resumeanalyser.entity.AnalysisResult;
import com.resumeanalyser.entity.JobDescription;
import com.resumeanalyser.entity.Resume;
import com.resumeanalyser.entity.Skill;
import com.resumeanalyser.service.AnalysisService;
import com.resumeanalyser.service.JobDescriptionService;
import com.resumeanalyser.service.ResumeService;
import com.resumeanalyser.service.UserService;

@RestController
@RequestMapping("/api/analyze")
public class AnalysisController {

    private final AnalysisService analysisService;
    private final ResumeService resumeService;
    private final JobDescriptionService jobDescriptionService;
    private final UserService userService;

    public AnalysisController(AnalysisService analysisService,
                              ResumeService resumeService,
                              JobDescriptionService jobDescriptionService,
                              UserService userService) {
        this.analysisService = analysisService;
        this.resumeService = resumeService;
        this.jobDescriptionService = jobDescriptionService;
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<AnalysisResponseDTO> analyze(
            @RequestParam Long userId,
            @RequestParam Long jdId) {

        Resume resume = resumeService.getResumeByUserId(userId);
        JobDescription jd = jobDescriptionService.getById(jdId);

        AnalysisResult result = analysisService.analyzeResumeAgainstJD(resume, jd);

        AnalysisResponseDTO dto = new AnalysisResponseDTO();
        dto.setAtsScore(result.getAtsScore());
        dto.setCreatedAt(result.getCreatedAt());

        dto.setMatchedSkills(
            result.getMatchedSkills().stream()
                  .map(Skill::getSkillName)
                  .toList()
        );

        dto.setMissingSkills(
            result.getMissingSkills().stream()
                  .map(Skill::getSkillName)
                  .toList()
        );

        return ResponseEntity.ok(dto);
    }

    }


