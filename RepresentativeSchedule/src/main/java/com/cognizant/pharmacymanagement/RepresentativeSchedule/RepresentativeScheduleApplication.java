package com.cognizant.pharmacymanagement.RepresentativeSchedule;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@org.springframework.cloud.openfeign.EnableFeignClients
public class RepresentativeScheduleApplication {

	public static void main(String[] args) {
		SpringApplication.run(RepresentativeScheduleApplication.class, args);
	}

}
