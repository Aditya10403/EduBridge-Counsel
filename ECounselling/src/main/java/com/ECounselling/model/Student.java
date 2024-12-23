package com.ECounselling.model;

import jakarta.persistence.*;

@Entity
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long studentId;

    private String studentName;
    private String contactNumber;
    private String address;
    private String board;
    private String schoolName;
    private String mailId;
    private Double tenthMarks;
    private Double twelveMarks;
    private String img;
    private Integer erank;

    public Student() { }

    public Student(Long studentId, String studentName, String contactNumber, String address, String board, String schoolName, String mailId, Double tenthMarks, Double twelveMarks, String img, Integer erank) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.contactNumber = contactNumber;
        this.address = address;
        this.board = board;
        this.schoolName = schoolName;
        this.mailId = mailId;
        this.tenthMarks = tenthMarks;
        this.twelveMarks = twelveMarks;
        this.img = img;
        this.erank = erank;
    }

    public Long getStudentId() {
        return studentId;
    }

    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getBoard() {
        return board;
    }

    public void setBoard(String board) {
        this.board = board;
    }

    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }

    public String getMailId() {
        return mailId;
    }

    public void setMailId(String mailId) {
        this.mailId = mailId;
    }

    public Double getTenthMarks() {
        return tenthMarks;
    }

    public void setTenthMarks(Double tenthMarks) {
        this.tenthMarks = tenthMarks;
    }

    public Double getTwelveMarks() {
        return twelveMarks;
    }

    public void setTwelveMarks(Double twelveMarks) {
        this.twelveMarks = twelveMarks;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public Integer getErank() {
        return erank;
    }

    public void setErank(Integer erank) {
        this.erank = erank;
    }
}
