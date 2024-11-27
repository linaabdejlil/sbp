package org.example.springbootproject.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "jobs") // NOM TAA TAB F DB//
@Data // generate getters, setters//
@NoArgsConstructor // / Lombok annotation to generate a no-argument constructor
@AllArgsConstructor //Lombok annotation to generate an argument constructor

public class Job {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String title;
    @Column(nullable = false)
    private String description;
    @Column(nullable = false)
    private String location ;
    @Column(nullable = false)
    private String company;
    private String industry;
    private String jobType;
    private String requirements;
}
