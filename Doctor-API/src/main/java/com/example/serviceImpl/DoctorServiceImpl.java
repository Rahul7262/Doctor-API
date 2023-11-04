package com.example.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entity.Doctor;
import com.example.repository.DoctorRepository;
import com.example.service.DoctorService;

@Service
public class DoctorServiceImpl implements DoctorService{
	
	@Autowired
	private DoctorRepository doctorRepository;


	public void saveDoctor(Doctor doctor) {
		
		doctorRepository.save(doctor);
	}

}
