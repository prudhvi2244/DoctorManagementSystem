package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Doctor;
import com.example.demo.service.IDoctorService;

@RestController
@RequestMapping(value = "/doctor")
public class DoctorController {

	@Autowired
	private IDoctorService dservice;
	
	/*
	 * http://localhost:8080/doctor/saveDoctor
	 */
	@PostMapping(value = "/saveDoctor",produces = "application/json",consumes = "application/json")
	public ResponseEntity<Doctor> saveDoctor(@RequestBody Doctor doctor)
	{
		Doctor savedDoctor=dservice.saveDoctor(doctor);
		return new ResponseEntity<Doctor>(savedDoctor,HttpStatus.CREATED);
	}
	
}
