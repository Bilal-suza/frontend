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

import com.example.staffLocate.Model.Requests;
import com.example.staffLocate.Services.RequestsServices;

@RestController
@RequestMapping("api/requests")
public class RequestsController {

    @Autowired
    private RequestsServices requestsServices;

    @PostMapping
    public ResponseEntity<Requests> createRequests(@RequestBody Requests requests) {
        Requests savedRequests = requestsServices.createRequests(requests);
        return new ResponseEntity<>(savedRequests, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Requests>> getAllRequests() {
        List<Requests> requests = requestsServices.getAllRequests();
        return new ResponseEntity<>(requests, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Requests> getRequestsById(@PathVariable("id") Long requestId) {
        Requests requests = requestsServices.getRequestsById(requestId);
        return new ResponseEntity<>(requests, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteRequests(@PathVariable("id") Long requestsId) {
        requestsServices.forDelete(requestsId);
        return new ResponseEntity<>("Requests is deleted", HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Requests> updateRequests(@PathVariable("id") Long requestId, @RequestBody Requests requests) {
        Requests updateRequests = requestsServices.updateRequests(requestId, requests);
        return new ResponseEntity<>(updateRequests, HttpStatus.OK);
    }
}
