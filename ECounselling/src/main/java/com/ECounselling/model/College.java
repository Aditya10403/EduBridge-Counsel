package com.ECounselling.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import java.util.List;


@Entity
@Table(name = "College")
public class College {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long collegeId;

    @Column(unique = true, nullable = false)
    private String collegeName;

    private String location;
    private String contactInfo;
    private Integer nirfRank;
    private Boolean status; // isBlocked

    @OneToMany(mappedBy = "college", cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<Department> departments;

    public College() {}

    public College(Long collegeId, String collegeName, String location, String contactInfo, Integer nirfRank, Boolean status, List<Department> departments) {
        this.collegeId = collegeId;
        this.collegeName = collegeName;
        this.location = location;
        this.contactInfo = contactInfo;
        this.nirfRank = nirfRank;
        this.status = status;
        this.departments = departments;
    }

    public Long getCollegeId() {
        return collegeId;
    }

    public void setCollegeId(Long collegeId) {
        this.collegeId = collegeId;
    }

    public String getCollegeName() {
        return collegeName;
    }

    public void setCollegeName(String collegeName) {
        this.collegeName = collegeName;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getContactInfo() {
        return contactInfo;
    }

    public void setContactInfo(String contactInfo) {
        this.contactInfo = contactInfo;
    }

    public Integer getNirfRank() {
        return nirfRank;
    }

    public void setNirfRank(Integer nirfRank) {
        this.nirfRank = nirfRank;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public List<Department> getDepartments() {
        return departments;
    }

    public void setDepartments(List<Department> departments) {
        this.departments = departments;
    }
}
