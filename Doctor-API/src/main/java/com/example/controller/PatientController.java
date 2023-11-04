package com.example.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.entity.Doctor;
import com.example.entity.Patient;
import com.example.service.PatientService;

@Controller
@RequestMapping("patient")
public class PatientController {

	@Autowired
	private PatientService patientService;

	@PostMapping("savePatient")
	public ResponseEntity<Patient> createDcoctor(@Valid @RequestBody Patient patient) {

		patientService.savePatient(patient);
		return ResponseEntity.status(HttpStatus.CREATED).body(patient);

	}

	@GetMapping("getdoctorlist/{patid}")
	public ResponseEntity<List<Doctor>> getDoctorList(@PathVariable int patid) {

		Patient patient = patientService.getPatient(patid);
		List<Doctor> dlist = patientService.getDoctorList(patient);
		return ResponseEntity.ok(dlist);
	}

}
