package org.example.springbootproject.service;

import org.example.springbootproject.Entities.Applicant;
import org.example.springbootproject.Repository.ApplicantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ApplicantService {

    @Autowired
    private ApplicantRepository applicantRepository;

    public Applicant saveApplicant(Applicant applicant) {
        return applicantRepository.save(applicant);
    }

    public List<Applicant> getAllApplicants() {
        return applicantRepository.findAll();
    }

    public Optional<Applicant> findByEmail(String email) {
        return applicantRepository.findByEmail(email);
    }

    public void deleteApplicant(Long id) {
        applicantRepository.deleteById(id);
    }

    public Optional<Applicant> findById(Long id) {
        return applicantRepository.findById(id);
    }
}
