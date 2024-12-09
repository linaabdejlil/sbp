package org.example.springbootproject.Controllers;

import org.example.springbootproject.Entities.Application;
import org.example.springbootproject.Entities.Applicant;
import org.example.springbootproject.Entities.Status;
import org.example.springbootproject.Services.ApplicationService;
import org.example.springbootproject.service.ApplicantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/applications")
public class ApplicationController {

    @Autowired
    private ApplicationService applicationService;

    @Autowired
    private ApplicantService applicantService;

    @PostMapping
    public ResponseEntity<Application> createApplication(
            @RequestParam("email") String email,
            @RequestParam("fullName") String fullName,
            @RequestParam("phone") String phone,
            @RequestParam("linkedin") String linkedin,
            @RequestParam("portfolio") String portfolio,
            @RequestParam("coverLetter") String coverLetter,
            @RequestParam("resume") MultipartFile resume) {

        try {
            Optional<Applicant> optionalApplicant = applicantService.findByEmail(email);
            Applicant applicant = optionalApplicant.orElseGet(() -> {
                Applicant newApplicant = new Applicant();
                newApplicant.setFullName(fullName);
                newApplicant.setEmail(email);
                newApplicant.setPhone(phone);
                newApplicant.setLnLink(linkedin);
                newApplicant.setPrfLink(portfolio);
                return applicantService.saveApplicant(newApplicant);
            });

            Application application = new Application();
            application.setApplicant(applicant);
            application.setCoverLetter(coverLetter);
            application.setResume(resume.getBytes());
            application.setStatus(Status.PENDING);
            Application savedApplication = applicationService.saveApplication(application);

            return ResponseEntity.ok(savedApplication);
        } catch (IOException e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping
    public List<Application> getAllApplications() {
        return applicationService.getAllApplications();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Application> getApplicationById(@PathVariable Long id) {
        Optional<Application> application = applicationService.findApplicationById(id);
        return application.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteApplication(@PathVariable Long id) {
        applicationService.deleteApplication(id);
        return ResponseEntity.noContent().build();
    }
}
