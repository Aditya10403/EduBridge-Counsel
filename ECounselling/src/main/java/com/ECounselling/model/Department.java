package com.ECounselling.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

@Entity
@Table(name = "Department")
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long departmentId;

    private String departmentName;
    private Integer noOfSeats;
    private Integer cutoffRank;

    @ManyToOne
    @JoinColumn(name = "college_id", nullable = false)
    @JsonBackReference
    private College college;

    public Department() {}

    public Department(Long departmentId, String departmentName, Integer noOfSeats, Integer cutoffRank, College college) {
        this.departmentId = departmentId;
        this.departmentName = departmentName;
        this.noOfSeats = noOfSeats;
        this.cutoffRank = cutoffRank;
        this.college = college;
    }

    public Long getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Long departmentId) {
        this.departmentId = departmentId;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public Integer getNoOfSeats() {
        return noOfSeats;
    }

    public void setNoOfSeats(Integer noOfSeats) {
        this.noOfSeats = noOfSeats;
    }

    public Integer getCutoffRank() {
        return cutoffRank;
    }

    public void setCutoffRank(Integer cutoffRank) {
        this.cutoffRank = cutoffRank;
    }

    public College getCollege() {
        return college;
    }

    public void setCollege(College college) {
        this.college = college;
    }
}

