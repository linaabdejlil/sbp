package org.example.springbootproject.Services;

import org.example.springbootproject.Entities.Application;
import org.example.springbootproject.Entities.Job;
import org.example.springbootproject.Entities.User;
import org.example.springbootproject.Repository.JobRepository;
import org.example.springbootproject.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ApplicationService {

    @Autowired
    private JobRepository jobRepository;

    @Autowired
    private UserRepository userRepository;

    private final List<Application> applications = new ArrayList<>();

    // Submit a new job application
    public Application submitApplication(Application application) {
        Job job = jobRepository.findById(application.getJob().getId())
                .orElseThrow(() -> new RuntimeException("Job not found with ID: " + application.getJob().getId()));

        User user = userRepository.findById(application.getUser().getId())
                .orElseThrow(() -> new RuntimeException("User not found with ID: " + application.getUser().getId()));
        application.setStatus("Submitted");
        applications.add(application); // Save application in memory
        return application;
    }

    public String getApplicationStatus(Long applicationId) {
        return applications.stream()
                .filter(application -> application.getId() == applicationId) // Use '==' instead of .equals()
                .map(Application::getStatus)
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Application not found with ID: " + applicationId));
    }

    public List<Application> getApplicationsByUser(Long userId) {
        return applications.stream()
                .filter(application -> application.getUser().getId() == userId) // Use '==' instead of .equals()
                .toList();
    }
}

