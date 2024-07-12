package com.example.staffLocate.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "staff")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Staff {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String fullName;
    private String staffEmail;
    private String departmentName;
    private String position;
    private String officeAddress;
    private String officeLocation;
    private String officeHours;
}
