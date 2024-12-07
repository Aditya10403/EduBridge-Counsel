package com.ECounselling.controller;

import com.ECounselling.model.College;
import com.ECounselling.response.ApiResponse;
import com.ECounselling.service.CollegeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/college")
public class CollegeController {

    @Autowired
    private CollegeService collegeService;

    @PostMapping("/add")
    public ResponseEntity<ApiResponse> addCollege(@RequestBody College c) {
        try {
            ApiResponse response = collegeService.addCollege(c);
            return ResponseEntity.status(response.getStatusCode()).body(response);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(
                    new ApiResponse(
                            HttpStatus.BAD_REQUEST.value(),
                            e.getMessage(),
                            null
                    )
            );
        }
    }

    @GetMapping("/all")
    public ResponseEntity<List<College>> getAllColleges() {
        List<College> colleges = collegeService.getAllColleges();
        return ResponseEntity.ok(colleges);
    }

    @GetMapping("/find/{collegeId}")
    public ResponseEntity<ApiResponse> getCollegeById(@PathVariable("collegeId") Long collegeId) {
        ApiResponse response = collegeService.getCollegeById(collegeId);
        return ResponseEntity.status(response.getStatusCode()).body(response);
    }

    @PutMapping("/update/{collegeId}")
    public ResponseEntity<ApiResponse> updateCollegeById(
            @PathVariable("collegeId") Long collegeId,
            @RequestBody College college) {
        ApiResponse response = collegeService.updateCollegeById(collegeId, college);
        return ResponseEntity.status(response.getStatusCode()).body(response);
    }

    @GetMapping("/findByName/{collegeName}")
    public ResponseEntity<ApiResponse> getCollegeByName(@PathVariable("collegeName") String collegeName) {
        ApiResponse response = collegeService.getCollegeByName(collegeName);
        return ResponseEntity.status(response.getStatusCode()).body(response);
    }

    @DeleteMapping("/delete/{collegeId}")
    public ResponseEntity<ApiResponse> deleteCollegeById(@PathVariable("collegeId") Long collegeId) {
        ApiResponse response = collegeService.deleteCollegeById(collegeId);
        return ResponseEntity.status(response.getStatusCode()).body(response);
    }

    @PutMapping("/updateStatus/{collegeId}")
    public ResponseEntity<ApiResponse> updateStatus(
            @PathVariable("collegeId") Long collegeId,
            @RequestBody College college) {
        ApiResponse response = collegeService.updateStatus(collegeId, college);
        return ResponseEntity.status(response.getStatusCode()).body(response);
    }
}
