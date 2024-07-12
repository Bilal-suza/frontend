package com.example.staffLocate.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.staffLocate.Model.Appointments;
import com.example.staffLocate.Repository.AppointmentsRepository;

@Service
public class AppointmentsServices {

    @Autowired
    private AppointmentsRepository appointmentsRepo;

    public Appointments createAppointments(Appointments appointments) {
        return appointmentsRepo.save(appointments);
    }

    public List<Appointments> getAllAppointments() {
        return appointmentsRepo.findAll();
    }

    public Appointments getAppointmentsById(Long appointmentId) {
        Optional<Appointments> appointments = appointmentsRepo.findById(appointmentId);
        return appointments.orElseThrow();
    }

    public void deleteAppointment(Long appointmentId) {
        appointmentsRepo.deleteById(appointmentId);
    }

    public Appointments updateAppointments(Long appointmentId, Appointments appointments) {
        Appointments oldAppointments = appointmentsRepo.findById(appointmentId).orElseThrow();
        oldAppointments.setStudentEmail(appointments.getStudentEmail());
        oldAppointments.setStudentNames(appointments.getStudentNames());
        oldAppointments.setAppointmentTime(appointments.getAppointmentTime());
        oldAppointments.setAppointmentDate(appointments.getAppointmentDate());
        oldAppointments.setStatus(appointments.getStatus());
        return appointmentsRepo.save(oldAppointments);
    }
}
