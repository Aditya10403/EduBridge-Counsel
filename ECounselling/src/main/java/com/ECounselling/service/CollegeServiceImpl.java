package com.ECounselling.service;

import com.ECounselling.exception.CollegeNotFoundException;
import com.ECounselling.model.College;
import com.ECounselling.repository.CollegeRepository;
import com.ECounselling.response.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CollegeServiceImpl implements CollegeService {

    @Autowired
    private CollegeRepository collegeRepository;

    @Override
    public ApiResponse addCollege(College c) {
        if (collegeRepository.existsByCollegeName(c.getCollegeName())) {
            throw new IllegalArgumentException("College with name '" + c.getCollegeName() + "' already exists");
        }
        College college = collegeRepository.save(c);
        return new ApiResponse(
                HttpStatus.CREATED.value(),
                "College added successfully",
                college
        );
    }

    @Override
    public List<College> getAllColleges() {
        return collegeRepository.findAll();
    }

    @Override
    public ApiResponse getCollegeById(Long collegeId) {
        College college = collegeRepository.findById(collegeId)
                .orElseThrow(() -> new CollegeNotFoundException("College not found with ID: " + collegeId));
        return new ApiResponse(
                HttpStatus.OK.value(),
                "College retrieved successfully",
                college
        );
    }

    @Override
    public ApiResponse updateCollegeById(Long collegeId, College c) {
        College existingCollege = collegeRepository.findById(collegeId)
                .orElseThrow(() -> new CollegeNotFoundException("College not found with ID: " + collegeId));

        existingCollege.setCollegeName(c.getCollegeName());
        existingCollege.setLocation(c.getLocation());
        existingCollege.setContactInfo(c.getContactInfo());
        existingCollege.setNirfRank(c.getNirfRank());
        existingCollege.setStatus(c.getStatus());

        College updatedCollege = collegeRepository.save(existingCollege);
        return new ApiResponse(
                HttpStatus.OK.value(),
                "College updated successfully",
                updatedCollege
        );
    }

    @Override
    public ApiResponse getCollegeByName(String collegeName) {
        College college = collegeRepository.findByCollegeName(collegeName)
                .orElseThrow(() -> new CollegeNotFoundException("College not found with name: " + collegeName));
        return new ApiResponse(
                HttpStatus.OK.value(),
                "College retrieved successfully",
                college
        );
    }

    @Override
    public ApiResponse deleteCollegeById(Long collegeId) {
        College college = collegeRepository.findById(collegeId)
                .orElseThrow(() -> new CollegeNotFoundException("College not found with ID: " + collegeId));
        collegeRepository.delete(college);
        return new ApiResponse(
                HttpStatus.OK.value(),
                "College deleted successfully",
                null
        );
    }

    @Override
    public ApiResponse updateStatus(Long collegeId, College c) {
        College college = collegeRepository.findById(collegeId)
                .orElseThrow(() -> new CollegeNotFoundException("College not found with ID: " + collegeId));

        college.setStatus(c.getStatus());
        College updatedCollege = collegeRepository.save(college);
        return new ApiResponse(
                HttpStatus.OK.value(),
                "College status updated successfully",
                updatedCollege
        );
    }
}
