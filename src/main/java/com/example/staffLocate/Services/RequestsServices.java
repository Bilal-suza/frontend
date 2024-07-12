package com.example.staffLocate.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.staffLocate.Model.Requests;
import com.example.staffLocate.Repository.RequestsRepository;

@Service
public class RequestsServices {

    @Autowired
    private RequestsRepository requestsRepos;

    public Requests createRequests(Requests requests) {
        return requestsRepos.save(requests);
    }

    public List<Requests> getAllRequests() {
        return requestsRepos.findAll();
    }

    public Requests getRequestsById(Long requestId) {
        Optional<Requests> requests = requestsRepos.findById(requestId);
        return requests.orElseThrow();
    }

    public void forDelete(Long requestId) {
        requestsRepos.deleteById(requestId);
    }

    public Requests updateRequests(Long requestId, Requests requests) {
        Requests oldRequests = requestsRepos.findById(requestId).orElseThrow();
        oldRequests.setStaffEmail(requests.getStaffEmail());
        oldRequests.setStudentEmail(requests.getStudentEmail());
        oldRequests.setRequestTime(requests.getRequestTime());
        oldRequests.setRequestDate(requests.getRequestDate());
        oldRequests.setPurpose(requests.getPurpose());
        oldRequests.setStatus(requests.getStatus());
        oldRequests.setStudentNames(requests.getStudentNames());
        return requestsRepos.save(oldRequests);
    }
}
