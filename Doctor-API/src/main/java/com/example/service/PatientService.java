package com.example.service;

import java.util.List;

import javax.validation.Valid;

import com.example.entity.Doctor;
import com.example.entity.Patient;

public interface PatientService {

	void savePatient(@Valid Patient patient);

	Patient getPatient(int patid);

	List<Doctor> getDoctorList(Patient patient);

}
