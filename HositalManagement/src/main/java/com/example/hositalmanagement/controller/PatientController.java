package com.example.hositalmanagement.controller;

import com.example.hositalmanagement.beans.Patient;
import com.example.hositalmanagement.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PatientController {

    @Autowired
    PatientService service;

    @GetMapping("/all")
    public List<Patient> getAllPatients(){
        return service.getAllPatients();
    }

    @PostMapping("/add")
    public Patient addPatient(@RequestBody Patient patient){
        return service.addPatient(patient);
    }
}
