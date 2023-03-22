package com.example.hositalmanagement.service;

import com.example.hositalmanagement.beans.Patient;

import java.util.List;

public interface PatientServiceImpl {

    List<Patient> getAllPatients();
    Patient addPatient(Patient patient);
}
