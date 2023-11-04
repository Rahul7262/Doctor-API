package com.example.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entity.Doctor;
import com.example.entity.Patient;
import com.example.exception.PatientNotFoundException;
import com.example.logical.SymptomSpeciality;
import com.example.repository.DoctorRepository;
import com.example.repository.PatientRepository;
import com.example.service.PatientService;

@Service
public class PatientServiceImpl implements PatientService {

	@Autowired
	private PatientRepository patientRepository;
	@Autowired
	private DoctorRepository doctorRepository;

	public void savePatient(Patient patient) {

		patientRepository.save(patient);
	}

	public Patient getPatient(int patid) {

		return patientRepository.findById(patid)
				.orElseThrow(() -> new PatientNotFoundException(" Patient does not exist"));

	}

	public List<Doctor> getDoctorList(Patient patient) {
		String pcity = patient.getCity();
		if (!pcity.equals("noida") && !pcity.equals("Delhi") && !pcity.equals("Faridabad")) {

			throw new RuntimeException("We are still waiting to expand to your location");
		}
		String symptom = patient.getSymptom();
		String speciality = SymptomSpeciality.map.get(symptom);
		List<Doctor> dlist = doctorRepository.getDoctorListBySymptomAndSpeciality(pcity, speciality);
		if (dlist.isEmpty()) {
			throw new RuntimeException("There isn’t any doctor present at your location for your symptom");
		}
		return dlist;
	}
}
