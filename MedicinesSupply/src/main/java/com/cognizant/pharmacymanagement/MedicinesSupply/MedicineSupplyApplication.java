package com.cognizant.pharmacymanagement.MedicinesSupply;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;


@SpringBootApplication
@EnableFeignClients
public class MedicineSupplyApplication {

	public static void main(String[] args) {
		SpringApplication.run(MedicineSupplyApplication.class, args);
	}

}
