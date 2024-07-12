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
import com.example.staffLocate.Model.Students;
import com.example.staffLocate.Services.StudentsServices;


@RestController
@RequestMapping("api/students") //create API
public class StudentsController {
    @Autowired
    private StudentsServices studentsServices;

    @PostMapping
    public ResponseEntity<Students> createStudents (@RequestBody Students students) {
        Students savedStudents = studentsServices.createStudents(students);
        return new ResponseEntity<>(savedStudents, HttpStatus.CREATED);

    }
    
    @GetMapping
    public ResponseEntity<List<Students>> getAllStudents() {
    List<Students> students = studentsServices.getAllStudents();
    return new ResponseEntity<>(students, HttpStatus.OK);
    }

    @GetMapping ("/{id}")
    public ResponseEntity<Students> getStudentsById (@PathVariable("id") Long studentsId){
        Students students = studentsServices.getStudentsById(studentsId);
        return new ResponseEntity<>(students, HttpStatus.OK);
    }

    @DeleteMapping ("/{id}")
    public ResponseEntity<String> deleteStudent (@PathVariable("id") Long students){
        studentsServices.forDelete(students);
        return new ResponseEntity<String>("Students is delete", HttpStatus.OK);
    } 

     @PutMapping ("/{id}")
    public ResponseEntity<Students> updateStudents(@PathVariable("id") Long studentsId, @RequestBody Students students){
        
        Students updateStudents = studentsServices.updateStudents(studentsId,students);
        return new ResponseEntity<>(updateStudents, HttpStatus.OK);
    }

    
}