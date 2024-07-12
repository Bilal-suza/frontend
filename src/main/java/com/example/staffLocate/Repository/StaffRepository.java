package com.example.staffLocate.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.staffLocate.Model.Staff;

public interface StaffRepository extends JpaRepository<Staff, Long> {
}
