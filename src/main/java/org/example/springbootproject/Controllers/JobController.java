package org.example.springbootproject.Controllers;

import org.example.springbootproject.Services.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/jobs")
public class JobController {

    @Autowired
    private JobService jobService;

    @GetMapping("/external")
    public String fetchJobsFromExternalApi(
            @RequestParam(required = false) String keywords,
            @RequestParam(required = false) String locationId,
            @RequestParam(required = false) String datePosted,
            @RequestParam(required = false) String jobType,
            @RequestParam(required = false) String sort) {
        return jobService.fetchJobsFromExternalApi(keywords, locationId, datePosted, jobType, sort);
    }
}
