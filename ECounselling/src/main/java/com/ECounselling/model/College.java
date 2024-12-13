package com.ECounselling.model;

import jakarta.persistence.*;

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

    public College() {}

    public College(Long collegeId, String collegeName, String location, String contactInfo, Integer nirfRank, Boolean status) {
        this.collegeId = collegeId;
        this.collegeName = collegeName;
        this.location = location;
        this.contactInfo = contactInfo;
        this.nirfRank = nirfRank;
        this.status = status;
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
}
