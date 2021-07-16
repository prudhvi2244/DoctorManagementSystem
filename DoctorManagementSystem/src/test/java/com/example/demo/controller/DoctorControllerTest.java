package com.example.demo.controller;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.example.demo.entity.Doctor;
import com.example.demo.service.DoctorServiceImpl;
import com.example.demo.service.IDoctorService;
import com.fasterxml.jackson.databind.ObjectMapper;

@WebMvcTest
public class DoctorControllerTest {

	@MockBean
	private IDoctorService dservice;
	
	@Autowired
	private MockMvc mvc;
	
	private static ObjectMapper mapper=new ObjectMapper();
	@Test
	public void testSaveDoctor() throws Exception
	{
		Doctor doctor=Doctor.builder().did(1).dname("Raj").specialization("Nose").build();
		when(dservice.saveDoctor(ArgumentMatchers.any())).thenReturn(doctor);
		
		String json=mapper.writeValueAsString(doctor);
		System.out.println(json);
		
		mvc.perform(post("/doctor/saveDoctor")
				    .contentType(MediaType.APPLICATION_JSON)
				    .characterEncoding("utf-8")
				    .content(json)
				    .accept(MediaType.APPLICATION_JSON))
					.andExpect(status().isCreated())
					.andExpect(jsonPath("$.did",Matchers.equalTo(1)))
					.andExpect(jsonPath("$.dname",Matchers.equalTo("Raj")))
					.andExpect(jsonPath("$.specialization",Matchers.equalTo("Nose")))
					;
					
				
	}
	
}
