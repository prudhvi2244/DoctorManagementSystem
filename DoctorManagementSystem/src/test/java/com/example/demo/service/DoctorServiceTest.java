package com.example.demo.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.example.demo.entity.Doctor;
import com.example.demo.repository.DoctorRepository;

@SpringBootTest
public class DoctorServiceTest {

	@Autowired
	private IDoctorService dservice;
	
	@MockBean
	private DoctorRepository drepo;
	
	@Test
	public void testSaveDoctor()
	{
		Doctor d1=new Doctor(1,"Prudhvi","ENT");
		when(drepo.save(d1)).thenReturn(d1);
		
		assertEquals(1,dservice.saveDoctor(d1).getDid());
		assertEquals(d1,dservice.saveDoctor(d1));
		assertNotNull(dservice.saveDoctor(d1));
		
	}
	
	
}
