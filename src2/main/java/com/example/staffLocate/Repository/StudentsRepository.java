package com.example.staffLocate.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.staffLocate.Model.Students;

public interface StudentsRepository extends JpaRepository<Students, Long> {
}
