package com.example.demo.repository;

import java.util.List;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.util.Assert;

import com.example.demo.entity.Doctor;

//@SpringBootTest
@DataJpaTest
public class DoctorRepositoryTest {

	@Autowired
	private DoctorRepository drepo;
	
	@Test
	@Order(1)
	public void testSaveDoctor()
	{
		Doctor doctor=Doctor.builder().dname("Raj").specialization("ENT").build();
		Doctor savedDoctorObject=drepo.save(doctor);
		System.out.println(savedDoctorObject);
		Assert.notNull(savedDoctorObject);
	}
	
	@Test
	@Order(2)
	public void testFindAllDoctors()
	{
	 List<Doctor> allDoctors=drepo.findAll();
	 System.out.println("**********************");
	 System.out.println(allDoctors);
	 Assert.notNull(allDoctors);
	}
	
	@Test
	public void testFindBySpecialization()
	{
		 List<Doctor> allDoctors=drepo.findBySpecialization("ENT");
		 System.out.println("**********************");
		 System.out.println(allDoctors);
		 Assert.notNull(allDoctors);
	}
	
}
