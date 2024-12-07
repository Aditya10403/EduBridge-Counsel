package com.ECounselling.repository;

import com.ECounselling.model.College;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CollegeRepository extends JpaRepository<College, Long> {
    List<College> findByCollegeName(String collegeName);
    boolean existsByCollegeName(String collegeName);
}
