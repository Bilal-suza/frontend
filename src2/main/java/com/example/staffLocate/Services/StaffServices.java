// StaffServices.java

package com.example.staffLocate.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.staffLocate.Model.Staff;
import com.example.staffLocate.Repository.StaffRepository;

@Service
public class StaffServices {

    @Autowired
    private StaffRepository staffRepo;

    public Staff createStaff(Staff staff) {
        return staffRepo.save(staff);
    }

    public List<Staff> getAllStaff() {
        return staffRepo.findAll();
    }

    public Staff getStaffById(Long staffId) {
        Optional<Staff> staff = staffRepo.findById(staffId);
        return staff.orElseThrow(() -> new RuntimeException("Staff member not found with id: " + staffId));
    }

    public void deleteStaff(Long staffId) {
        staffRepo.deleteById(staffId);
    }

    public Staff updateStaff(Long staffId, Staff staff) {
        Staff oldStaff = staffRepo.findById(staffId)
            .orElseThrow(() -> new RuntimeException("Staff member not found with id: " + staffId));
        
        // Update only the fields that are allowed to be updated
        oldStaff.setFullName(staff.getFullName());
        oldStaff.setStaffEmail(staff.getStaffEmail());
        oldStaff.setDepartmentName(staff.getDepartmentName());
        oldStaff.setPosition(staff.getPosition());
        oldStaff.setOfficeAddress(staff.getOfficeAddress());
        oldStaff.setOfficeLocation(staff.getOfficeLocation());
        oldStaff.setOfficeHours(staff.getOfficeHours());

        return staffRepo.save(oldStaff);
    }
}
