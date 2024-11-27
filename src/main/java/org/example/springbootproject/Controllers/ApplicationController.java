package org.example.springbootproject.Controllers;

import org.example.springbootproject.Entities.Application;
import org.example.springbootproject.Services.ApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/applications")
public class ApplicationController {

    @Autowired
    private ApplicationService applicationService;

    // Submit a new job application
    @PostMapping("/submit")
    public Application submitApplication(@RequestBody Application application) {
        return applicationService.submitApplication(application);
    }

    // Get application status by ID
    @GetMapping("/{id}/status")
    public String getApplicationStatus(@PathVariable Long id) {
        return applicationService.getApplicationStatus(id);
    }

    // Get all applications for a user
    @GetMapping("/user/{userId}")
    public List<Application> getApplicationsByUser(@PathVariable Long userId) {
        return applicationService.getApplicationsByUser(userId);
    }
}
