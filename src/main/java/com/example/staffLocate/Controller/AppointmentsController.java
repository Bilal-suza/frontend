package com.example.staffLocate.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.staffLocate.Model.Appointments;
import com.example.staffLocate.Services.AppointmentsServices;

import java.util.List;

@RestController
@RequestMapping("/api/appointments")
public class AppointmentsController {

    @Autowired
    private AppointmentsServices appointmentsServices;

    @PostMapping
    public Appointments createAppointment(@RequestBody Appointments appointments) {
        return appointmentsServices.createAppointments(appointments);
    }

    @GetMapping
    public List<Appointments> getAllAppointments() {
        return appointmentsServices.getAllAppointments();
    }

    @GetMapping("/{id}")
    public Appointments getAppointmentById(@PathVariable Long id) {
        return appointmentsServices.getAppointmentsById(id);
    }

    @PutMapping("/{id}")
    public Appointments updateAppointment(@PathVariable Long id, @RequestBody Appointments appointments) {
        return appointmentsServices.updateAppointments(id, appointments);
    }

    @DeleteMapping("/{id}")
    public void deleteAppointment(@PathVariable Long id) {
        appointmentsServices.deleteAppointment(id);
    }
}
