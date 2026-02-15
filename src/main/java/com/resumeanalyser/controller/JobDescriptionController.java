package com.resumeanalyser.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.resumeanalyser.entity.JobDescription;
import com.resumeanalyser.entity.User;
import com.resumeanalyser.service.JobDescriptionService;
import com.resumeanalyser.service.UserService;

import java.util.List;

@RestController
@RequestMapping("/api/jd")
public class JobDescriptionController {

    private final JobDescriptionService jobDescriptionService;
    private final UserService userService;

    public JobDescriptionController(JobDescriptionService jobDescriptionService,
                                    UserService userService) {
        this.jobDescriptionService = jobDescriptionService;
        this.userService = userService;
    }

    @PostMapping("/submit")
    public ResponseEntity<JobDescription> submitJD(
            @RequestParam Long userId,
            @RequestBody String jdText) {

        User user = userService.getUserById(userId);
        JobDescription jd = jobDescriptionService.saveJobDescription(user, jdText);
        return ResponseEntity.ok(jd);
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<JobDescription>> getJDs(@PathVariable Long userId) {
        User user = userService.getUserById(userId);
        return ResponseEntity.ok(jobDescriptionService.getJobDescriptionsByUser(user));
    }
}

