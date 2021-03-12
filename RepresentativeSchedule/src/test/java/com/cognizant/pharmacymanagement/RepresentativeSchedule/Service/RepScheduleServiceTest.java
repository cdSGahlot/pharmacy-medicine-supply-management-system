package com.cognizant.pharmacymanagement.RepresentativeSchedule.Service;

import static org.junit.Assert.*;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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
import com.cognizant.pharmacymanagement.RepresentativeSchedule.Model.RepSchedule;
import com.cognizant.pharmacymanagement.RepresentativeSchedule.feignClient.StockFeignClient;
import com.cognizant.pharmacymanagement.RepresentativeSchedule.Service.*;


@RunWith(SpringRunner.class)
@SpringBootTest
public class RepScheduleServiceTest {
	
	@InjectMocks
	private RepScheduleService repScheduleService;
	
	
	@Mock
	private RepService repService;
	
	@Mock
	private Doctor doctor;
	
	@Mock
	private DoctorService doctorService;
	

	@Test
	public void testReturnSchedule() throws ParseException {
		
		assertNotNull(repScheduleService.returnschedule("2021-03-12"));
	}
	@Test
	public void testStringtoDate() throws ParseException {
		
		Date date = repScheduleService.StringtoDate("2021-03-12");
		assertEquals(date,new SimpleDateFormat("dd-MM-yyyy").parse("12-03-2021"));
	}
	@Test
	public void testFindNextDay() throws ParseException {
		
		assertEquals(repScheduleService.findNextDay(new SimpleDateFormat("dd-MM-yyyy").parse("12-03-2021")),new SimpleDateFormat("dd-MM-yyyy").parse("13-03-2021"));
	}
}
