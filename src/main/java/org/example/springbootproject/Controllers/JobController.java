package org.example.springbootproject.Controllers;

import org.example.springbootproject.Services.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/jobs")
public class JobController {

    @Autowired
    private JobService jobService;

    // Fetch jobs from Indeed API
    @GetMapping("/external")
    public String fetchJobsFromExternalApi(
            @RequestParam String country ,
            @RequestParam int sort,
            @RequestParam int pageSize) {
        return jobService.fetchJobsFromExternalApi(null, 0, 0);
    }
}
