package com.iqac.model;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "Faculty_Details")
public class FacultyDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String email;
    private String department;
    private String contactNumber;
    private LocalDate joiningDate;
    private String designation;
    private String address;

    public FacultyDetails() {
    }

    public FacultyDetails(String name, String email, String department, String contactNumber, LocalDate joiningDate, String designation, String address) {
        this.name = name;
        this.email = email;
        this.department = department;
        this.contactNumber = contactNumber;
        this.joiningDate = joiningDate;
        this.designation = designation;
        this.address = address;
    }
}
