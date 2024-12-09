package org.example.springbootproject.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;

@Service
public class JobService {

    private final WebClient webClient;

    @Autowired
    public JobService(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder.baseUrl("https://linkedin-data-api.p.rapidapi.com").build();
    }

    public String fetchJobsFromExternalApi(String keywords, String locationId, String datePosted, String jobType, String sort) {
        String response = webClient.get()
                .uri(uriBuilder -> {
                    var builder = uriBuilder
                            .path("/search-jobs");

                    if (keywords != null) {
                        builder.queryParam("keywords", keywords);
                    }
                    if (locationId != null) {
                        builder.queryParam("locationId", locationId);
                    }
                    if (datePosted != null) {
                        builder.queryParam("datePosted", datePosted);
                    }
                    if (jobType != null) {
                        builder.queryParam("jobType", jobType);
                    }
                    if (sort != null) {
                        builder.queryParam("sort", sort);
                    }
                    return builder.build();
                })
                .header("x-rapidapi-key", "ce9b10740emsh59585afd6f4f148p1397acjsn398caa8acbd7")
                .header("x-rapidapi-host", "linkedin-data-api.p.rapidapi.com")
                .retrieve()
                .bodyToMono(String.class)
                .block();

        return response;
    }
}