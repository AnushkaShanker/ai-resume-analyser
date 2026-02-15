package com.resumeanalyser.service;

import org.springframework.web.multipart.MultipartFile;

import com.resumeanalyser.entity.Resume;
import com.resumeanalyser.entity.User;

public interface ResumeService {

    Resume uploadOrUpdateResume(User user, MultipartFile filePath);

	Resume getResumeByUserId(Long userId);
}
