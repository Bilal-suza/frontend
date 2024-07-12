package com.example.staffLocate.Services;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.example.staffLocate.Model.Students;
import com.example.staffLocate.Repository.StudentsRepository;

@Service
    public class StudentsServices {
        
        @Autowired
        private StudentsRepository studentsRepo;
        public Students createStudents (Students students){
            return studentsRepo.save(students);
        
    }

    public List <Students> getAllStudents(){
        return studentsRepo.findAll();
        
    }

    public Students getStudentsById (Long students) {
        Optional <Students> studentsId = studentsRepo.findById(students);
        return studentsId.get();
        
    }

    public void forDelete (Long students) {
        studentsRepo.deleteById(students);
    }

    public Students updateStudents (Long studentsId, Students students) {
        Students oldStudents = studentsRepo.findById(studentsId).orElseThrow();
            oldStudents.setStudentNames(students.getStudentNames());
            oldStudents.setStudentEmail(students.getStudentEmail());
            oldStudents.setPhoneNumber(students.getPhoneNumber());
            oldStudents.setGender(students.getGender());
            oldStudents.setAddress(students.getAddress());

            Students updateStudents = studentsRepo.save(oldStudents);
            return updateStudents;
    }

    
    
}