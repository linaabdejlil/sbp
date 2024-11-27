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
        this.webClient = webClientBuilder.baseUrl("https://active-jobs-db.p.rapidapi.com").build();
    }

    public String fetchJobsFromExternalApi(String country, int sort, int pageSize) {
        return webClient.get()
                .uri(uriBuilder -> uriBuilder
                        .path("/active-ats-7d")
                        // Add query params if needed (example: .queryParam("country", country))
                        .build())
                .header("x-rapidapi-key", "4c5647bd2emsh2a44e97aad67149p1fe830jsnf0233f78ee8f") // Replace with actual API key
                .header("x-rapidapi-host", "active-jobs-db.p.rapidapi.com")
                .retrieve()
                .bodyToMono(String.class) // Get the raw response as a String (JSON)
                .block(); // Blocks the request until response is returned
    }
}
