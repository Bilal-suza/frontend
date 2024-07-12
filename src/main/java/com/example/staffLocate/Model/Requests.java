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
@Table(name = "requests")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Requests {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String staffEmail;
    private String studentNames;
    private String studentEmail;
    private String requestTime;
    private String requestDate;
    private String purpose;
    private String status;
}
