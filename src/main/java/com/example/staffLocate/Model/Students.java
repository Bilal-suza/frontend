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
@Table(name="students")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Students {
    public static final String HttpStatus = null;
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    private String studentNames;
    private String studentEmail;
    private String phoneNumber;
    private String gender;
    private String address;
}