package com.ECounselling.model;

import jakarta.persistence.*;

@Entity
@Table(name = "Admin")
public class Admin {

    @Id
    private String userId;

    @Column(nullable = false)
    private String password;

    private String role = "ADMIN";

    // Constructors
    public Admin() {}

    public Admin(String userId, String password) {
        this.userId = userId;
        this.password = password;
    }
}

