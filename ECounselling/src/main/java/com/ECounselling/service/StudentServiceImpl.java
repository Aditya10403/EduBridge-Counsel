package com.ECounselling.service;

import com.ECounselling.exception.StudentNotFoundException;
import com.ECounselling.model.Student;
import com.ECounselling.repository.StudentRepository;
import com.ECounselling.response.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public ApiResponse addStudentData(Student student) {
        if (studentRepository.existsByMailId(student.getMailId())) {
            throw new IllegalArgumentException("Student with email '" + student.getMailId() + "' already exists");
        }
        Student savedStudent = studentRepository.save(student);
        return new ApiResponse(
                HttpStatus.CREATED.value(),
                "Student added successfully",
                savedStudent
        );
    }

    @Override
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    @Override
    public ApiResponse getStudentById(Long studentId) {
        Student student = studentRepository.findById(studentId)
                .orElseThrow(() -> new StudentNotFoundException("Student not found with ID: " + studentId));
        return new ApiResponse(
                HttpStatus.OK.value(),
                "Student retrieved successfully",
                student
        );
    }

    @Override
    public ApiResponse updateStudentByMail(String mailId, Student student) {
        Student existingStudent = studentRepository.findByMailId(mailId)
                .orElseThrow(() -> new StudentNotFoundException("Student not found with email: " + mailId));
        updateStudentFields(existingStudent, student);
        Student updatedStudent = studentRepository.save(existingStudent);
        return new ApiResponse(
                HttpStatus.OK.value(),
                "Student updated successfully",
                updatedStudent
        );
    }

    @Override
    public ApiResponse verifyMail(String mailId) {
        boolean exists = studentRepository.existsByMailId(mailId);
        return new ApiResponse(
                exists ? HttpStatus.OK.value() : HttpStatus.NOT_FOUND.value(),
                exists ? "Mail ID verified successfully" : "Mail ID not found",
                exists
        );
    }

    private void updateStudentFields(Student existingStudent, Student student) {
        existingStudent.setStudentName(student.getStudentName());
        existingStudent.setAddress(student.getAddress());
        existingStudent.setBoard(student.getBoard());
        existingStudent.setSchoolName(student.getSchoolName());
        existingStudent.setMailId(student.getMailId());
        existingStudent.setTenthMarks(student.getTenthMarks());
        existingStudent.setTwelveMarks(student.getTwelveMarks());
    }
}
