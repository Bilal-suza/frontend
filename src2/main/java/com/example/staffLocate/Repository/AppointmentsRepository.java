package com.example.staffLocate.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.staffLocate.Model.Appointments;

public interface AppointmentsRepository extends JpaRepository<Appointments, Long> {
}
