package com.example.hositalmanagement.service;

import com.example.hositalmanagement.beans.Patient;
import com.example.hositalmanagement.repository.PatientRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientService implements PatientServiceImpl{

    @Autowired
    PatientRepo repo;

    @Override
    public List<Patient> getAllPatients() {
        return repo.findAll();
    }

    @Override
    public Patient addPatient(Patient patient) {
        return repo.save(patient);
    }
}
