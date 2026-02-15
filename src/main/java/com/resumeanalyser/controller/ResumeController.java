package com.resumeanalyser.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import com.resumeanalyser.dto.ResumeResponseDTO;
import com.resumeanalyser.entity.Resume;
import com.resumeanalyser.entity.User;
import com.resumeanalyser.service.ResumeService;
import com.resumeanalyser.service.UserService;

@RestController
@RequestMapping("/api/resume")
public class ResumeController {

    private final ResumeService resumeService;
    private final UserService userService;

    public ResumeController(ResumeService resumeService, UserService userService) {
        this.resumeService = resumeService;
        this.userService = userService;
    }

    @PostMapping("/upload")
    public ResponseEntity<ResumeResponseDTO> uploadResume(
            @RequestParam Long userId,
            @RequestParam("file") MultipartFile file) {

        User user = userService.getUserById(userId);
        Resume resume = resumeService.uploadOrUpdateResume(user, file);

        ResumeResponseDTO dto = new ResumeResponseDTO();
        dto.setResumeId(resume.getResumeId());
        dto.setFilePath(resume.getFilePath());
        dto.setUploadedAt(resume.getUploadedAt());

        return ResponseEntity.ok(dto);
    }

}

