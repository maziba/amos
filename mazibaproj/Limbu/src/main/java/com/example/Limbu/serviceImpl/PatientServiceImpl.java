package com.example.Limbu.serviceImpl;

import com.example.Limbu.entity.Patient;
import com.example.Limbu.exception.PatientException;
import com.example.Limbu.repository.PatientRepository;
import com.example.Limbu.service.PatientService;

import java.util.List;

public class PatientServiceImpl implements PatientService {

    private PatientRepository patientRepository;

    public PatientServiceImpl(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    @Override
    public Patient addPatient(Patient patient) {
        return patientRepository.save(patient);
    }

    @Override
    public List<Patient> getAllPatient() {
        return patientRepository.findAll();
    }

    @Override
    public Patient getPatientById(Long id) {
        Patient patient = patientRepository.findById(id)
                .orElseThrow(()->new PatientException("Not found"));
        return patient;
    }

    @Override
    public Patient updatePatient(Long id, Patient patient) {
        Patient patient1 = patientRepository.findById(id)
                .orElseThrow(()->new PatientException("Not found"));

        patient1.setPatientID(patient.getPatientID());
        patient1.setPatientAddress(patient.getPatientAddress());
        patient1.setPatientName(patient.getPatientName());

        Patient updatePatient = patientRepository.save(patient1);
        return updatePatient;
    }

    @Override
    public void deletePatient(Long id) {
        Patient patient = patientRepository.findById(id)
                .orElseThrow(()->new PatientException("Not found"));

        patientRepository.delete(patient);
    }
}
