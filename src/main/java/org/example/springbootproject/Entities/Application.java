package org.example.springbootproject.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "applications") // NOM TAA TAB F DB//
@Data // generate getters, setters//
@NoArgsConstructor // / Lombok annotation to generate a no-argument constructor
@AllArgsConstructor

public class Application {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;
    @ManyToOne
    @JoinColumn(name = "job_id", nullable = false)
    private Job job;
    @Column(nullable = false)
    private String resume;
    @Column(nullable = false)
    private String status; // accepted , applied , under review , rejected


}
