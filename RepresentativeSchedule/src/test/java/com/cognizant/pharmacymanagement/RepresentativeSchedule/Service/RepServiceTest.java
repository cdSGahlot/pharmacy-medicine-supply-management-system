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

import com.cognizant.pharmacymanagement.RepresentativeSchedule.Service.*;


@RunWith(SpringRunner.class)
@SpringBootTest
public class RepServiceTest {
	
	@InjectMocks
	private RepService repService;
	
	@Test
	public void testRetrieveMark() {
		assertNotNull(repService.retrieveRep());
	}
}

