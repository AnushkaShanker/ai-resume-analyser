package service;

import entity.Resume;
import entity.User;
import repository.ResumeRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class ResumeServiceImpl implements ResumeService {

    private final ResumeRepository resumeRepository;

    public ResumeServiceImpl(ResumeRepository resumeRepository) {
        this.resumeRepository = resumeRepository;
    }

    @Override
    public Resume uploadOrUpdateResume(User user, String filePath) {
        Resume resume = resumeRepository.findByUser(user)
                .orElse(new Resume());

        resume.setUser(user);
        resume.setFilePath(filePath);
        resume.setUploadedAt(LocalDateTime.now());

        return resumeRepository.save(resume);
    }
}
