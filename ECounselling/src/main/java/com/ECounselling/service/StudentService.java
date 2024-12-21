package com.ECounselling.service;

import com.ECounselling.model.Department;
import com.ECounselling.model.Student;
import com.ECounselling.response.ApiResponse;

import java.util.List;
import java.util.Map;

public interface StudentService {
    ApiResponse addStudentData(Student student);
    List<Student> getAllStudents();
    ApiResponse getStudentById(Long id);
    ApiResponse updateStudentByMail(String mailId, Student s);
    ApiResponse verifyMail(String mailId);
    List<Map<String, Object>> getDepartmentsByERank(Integer erank);
}
