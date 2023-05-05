package com.example.Limbu.service;

import com.example.Limbu.entity.Patient;

import java.util.List;

public interface PatientService {

    //create
    Patient addPatient(Patient patient);
    //get all patient
    List<Patient> getAllPatient();
    //get patient by id
    Patient getPatientById(Long id);
    //update
    Patient updatePatient(Long id, Patient patient);
    //delete
    void deletePatient(Long id);
}
