package org.example.springbootproject.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "applicants") // NOM TAA TAB F DB//
@Data // generate getters, setters//
@NoArgsConstructor // / Lombok annotation to generate a no-argument constructor
@AllArgsConstructor
public class Applicant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(nullable = false)
    private String fullName;
    @Column(nullable = false, unique = true)
    private String email;
    @Column(nullable = false)
    private String phone;
    @Column(nullable = true)
    private String LnLink;
    @Column(nullable = true)
    private String prfLink;




}
