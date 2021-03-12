package com.cognizant.pharmacymanagement.MedicinesSupply.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.cognizant.pharmacymanagement.MedicinesSupply.MedicineSupplyApplication;
import com.cognizant.pharmacymanagement.MedicinesSupply.feingClient.StockFeignClient;
import com.cognizant.pharmacymanagement.MedicinesSupply.model.Medicine;
import com.cognizant.pharmacymanagement.MedicinesSupply.service.PharmacyMedicineSupplyService;


@RestController
public class MedicineSupplyController {
	
	private static Logger LOGGER = LoggerFactory.getLogger(MedicineSupplyApplication.class);
	
	@Autowired
	PharmacyMedicineSupplyService service;
	
	@Autowired
	private StockFeignClient stockFeignClient;
	
	
	@RequestMapping(value="/viewDemand", method = RequestMethod.GET)
	public String showSupplyHomePage(@RequestHeader("Authorization") String token){
		LOGGER.info("Starting showSupplyHomePage");
		if (service.isSessionValid(token)) {
			return "viewDemand";
		}
		LOGGER.info("Ending showSupplyHomePage");
		return "login";
	}


	@GetMapping(value="/SupplyAvailed")
	public ResponseEntity<?> showList(@RequestHeader("Authorization") String token, @RequestParam String name, @RequestParam int demand){
		LOGGER.info("Starting showList");
		if (service.isSessionValid(token)) {
			int stock = stockFeignClient.getStockCountForMedicine(name);
			//service.stockDivide(demand,name,stock);
			//model.put("pharmacyList", service.retrievePharmacies());
			//return new ModelAndView ("SupplyAvailed");
			LOGGER.info("Ending showList");
			return new ResponseEntity<>(service.retrievePharmacies(token,demand,name,stock), HttpStatus.OK);
		}
		LOGGER.info("Ending showList");
		return null;
	}
	
	
	
}
	
	