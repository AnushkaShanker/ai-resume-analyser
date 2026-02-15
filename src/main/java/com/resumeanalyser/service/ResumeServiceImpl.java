package com.resumeanalyser.service;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.resumeanalyser.entity.Resume;
import com.resumeanalyser.entity.User;
import com.resumeanalyser.repository.ResumeRepository;

import java.time.LocalDateTime;

@Service
public class ResumeServiceImpl implements ResumeService {

    private final ResumeRepository resumeRepository;
    private final FileStorageService fileStorageService;

    public ResumeServiceImpl(ResumeRepository resumeRepository,
                             FileStorageService fileStorageService) {
        this.resumeRepository = resumeRepository;
        this.fileStorageService = fileStorageService;
    }

    @Override
    public Resume uploadOrUpdateResume(User user, MultipartFile file) {

        String storedFilePath = fileStorageService.storeFile(file);

        Resume resume = resumeRepository.findByUser(user)
                .orElse(new Resume());

        resume.setUser(user);
        resume.setFilePath(storedFilePath);
        resume.setUploadedAt(LocalDateTime.now());

        return resumeRepository.save(resume);
    }

	@Override
	public Resume getResumeByUserId(Long userId) {
		// TODO Auto-generated method stub
		return null;
	}
}
