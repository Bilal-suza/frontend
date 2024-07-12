package com.example.staffLocate.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.staffLocate.Model.Staff;
import com.example.staffLocate.Services.StaffServices;


@RestController
@RequestMapping("/api/staff")
public class StaffController {

    @Autowired
    private StaffServices staffServices;

    @PostMapping
    public ResponseEntity<Staff> createStaff(@RequestBody Staff staff) {
        Staff savedStaff = staffServices.createStaff(staff);
        return new ResponseEntity<>(savedStaff, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Staff>> getAllStaff() {
        List<Staff> staff = staffServices.getAllStaff();
        return new ResponseEntity<>(staff, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Staff> getStaffById(@PathVariable("id") Long staffId) {
        Staff staff = staffServices.getStaffById(staffId);
        return new ResponseEntity<>(staff, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteStaff(@PathVariable("id") Long staffId) {
        staffServices.deleteStaff(staffId);
        return new ResponseEntity<>("Staff deleted successfully", HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Staff> updateStaff(@PathVariable("id") Long staffId, @RequestBody Staff staff) {
        Staff updatedStaff = staffServices.updateStaff(staffId, staff);
        return new ResponseEntity<>(updatedStaff, HttpStatus.OK);
    }
}
