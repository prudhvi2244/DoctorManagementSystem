package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Doctor;
import com.example.demo.repository.DoctorRepository;
@Service
public class DoctorServiceImpl implements IDoctorService {

	@Autowired
	private DoctorRepository drepo;

	@Override
	public Doctor saveDoctor(Doctor doctor) {
		Doctor d=drepo.save(doctor);
		System.out.println(d);
		return d;

	}

}
