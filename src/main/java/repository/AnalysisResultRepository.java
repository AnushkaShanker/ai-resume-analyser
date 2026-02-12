package repository;

import entity.AnalysisResult;
import entity.JobDescription;
import entity.Resume;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AnalysisResultRepository extends JpaRepository<AnalysisResult, Long> {

    Optional<AnalysisResult> findByResumeAndJobDescription(Resume resume, JobDescription jobDescription);
}