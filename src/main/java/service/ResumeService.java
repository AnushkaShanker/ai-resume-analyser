package service;

import entity.Resume;
import entity.User;

public interface ResumeService {

    Resume uploadOrUpdateResume(User user, String filePath);
}
