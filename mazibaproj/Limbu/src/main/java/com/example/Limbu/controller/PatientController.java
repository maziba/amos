package com.example.Limbu.controller;

import com.example.Limbu.entity.Patient;
import com.example.Limbu.service.PatientService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/limbu/patient")
public class PatientController {

    private PatientService patientService;

    public PatientController(PatientService patientService) {
        this.patientService = patientService;
    }

    //create
    @PostMapping
    public ResponseEntity<Patient> addPatient(@RequestBody Patient patient){
        return new ResponseEntity<>(patientService.addPatient(patient), HttpStatus.CREATED);
    }

    //GET ALL
    @GetMapping
    public List<Patient> getAllPatient(){
        return patientService.getAllPatient();
    }

    //get by id
    @GetMapping("{id}")
    public ResponseEntity<Patient> getById(@PathVariable Long id){
        return new ResponseEntity<>(patientService.getPatientById(id), HttpStatus.OK);
    }

    //update
    @PutMapping("{id}")
    public ResponseEntity<Patient> updatePatient(@PathVariable Long id, @RequestBody Patient patient){
        return new ResponseEntity<>(patientService.updatePatient(id, patient), HttpStatus.OK);
    }

    //delete
    @DeleteMapping("{id}")
    public ResponseEntity<String> deletePatient(@PathVariable Long id){
        patientService.deletePatient(id);
        return new ResponseEntity<>("Deleted", HttpStatus.OK);
    }

}
