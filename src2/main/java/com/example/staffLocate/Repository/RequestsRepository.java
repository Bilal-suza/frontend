package com.example.staffLocate.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.staffLocate.Model.Requests;

public interface RequestsRepository extends JpaRepository<Requests, Long> {
}
