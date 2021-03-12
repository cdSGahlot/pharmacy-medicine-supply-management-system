package com.cognizant.pharmacymanagement.RepresentativeSchedule.Service;


import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.cognizant.pharmacymanagement.RepresentativeSchedule.Model.Doctor;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DoctorServiceTest {
	
	@InjectMocks
	private DoctorService doctorService;
	
	@Mock
	private Doctor doctor;
	
	
	@Test
	public void testRetrieveDocwhenAllottedisTrue() {
		doctor.setAllotted(true);
		Doctor doc1= doctorService.retrieveDoc();
		assertNotNull(doc1);
	}
	
	@Test
	public void testRetrieveDoc() {
		Doctor doc1= doctorService.retrieveDoc("D1");
		assertNotNull(doc1);
	}
	
	@Test
	public void testSetAllottmentwhenTrue() {
		doctorService.setAllotment("D1");
		boolean allot = doctorService.getDoclist().get(0).isAllotted();
		assertTrue(allot);
		
	}

	@Test
	public void testSetAllottmentwhenFalse() {
		doctorService.setAllotment("D1");
		boolean allot = doctorService.getDoclist().get(1).isAllotted();
		assertFalse(allot);
	}
	
	@Test
	public void testResetAllotment() {
		doctorService.setAllotment("D1");
		doctorService.resetAllotment();
		boolean allot = doctorService.getDoclist().get(0).isAllotted();
		assertFalse(allot);
		
	}
	
	@Test
	public void testGetDocList() {
		assertNotNull(doctorService.getDoclist());
	}
	
	@Test
	public void testGetDocCount() {
		assertNotNull(doctorService.getDocCount());
	}
	
	@Test
	public void testSetDocCount() {
		doctorService.setDocCount(3);
		assertEquals(doctorService.getDocCount(),3);
	}
}
