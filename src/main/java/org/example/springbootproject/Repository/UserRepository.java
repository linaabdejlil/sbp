package org.example.springbootproject.Repository;

import org.example.springbootproject.Entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmail(String email);
    boolean existsByEmail (String email);
}
