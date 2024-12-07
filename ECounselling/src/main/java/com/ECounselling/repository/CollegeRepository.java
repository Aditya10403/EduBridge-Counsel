package com.ECounselling.repository;

import com.ECounselling.model.College;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CollegeRepository extends JpaRepository<College, Long> {
    Optional<College> findByCollegeName(String collegeName);
    boolean existsByCollegeName(String collegeName);
}
