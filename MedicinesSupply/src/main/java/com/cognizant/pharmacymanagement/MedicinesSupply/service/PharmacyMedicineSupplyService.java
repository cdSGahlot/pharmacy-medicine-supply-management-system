package com.cognizant.pharmacymanagement.MedicinesSupply.service;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.pharmacymanagement.MedicinesSupply.feingClient.AuthClient;
import com.cognizant.pharmacymanagement.MedicinesSupply.feingClient.StockFeignClient;
import com.cognizant.pharmacymanagement.MedicinesSupply.model.*;



@Service
public class PharmacyMedicineSupplyService {
	
	private static int supply=0;
	
	private static String medName;
	PharmacyList ph;
	
	@Autowired
	private StockFeignClient stockFeignClient;
	
	@Autowired
	private AuthClient authClient;
	
	private static int stock;
	
	private static List<PharmacyMedicineSupply> pharmacyList = new ArrayList<PharmacyMedicineSupply>();
	//private static List<PharmacyMedicineSupply> EmptyList = new ArrayList<PharmacyMedicineSupply>();
    
	
    public List<PharmacyMedicineSupply> retrievePharmacies(String token, int demand,String medicine, int stock) {
    	if (isSessionValid(token)) {	
    		pharmacyList.clear();
	    	if (demand>stock) {
	    		supply=0;
	    		return pharmacyList;
	    	}
	    	else {
	    		supply=demand/5;
	    	}
	    	medName = medicine;
	    	pharmacyList.add(new PharmacyMedicineSupply("MedCity",medName,supply));
	    	pharmacyList.add(new PharmacyMedicineSupply("Med 7",medName,supply));
	    	pharmacyList.add(new PharmacyMedicineSupply("PharmaOne",medName,supply));
	    	pharmacyList.add(new PharmacyMedicineSupply("MediLane",medName,supply));
	    	pharmacyList.add(new PharmacyMedicineSupply("Pharma Plus",medName,supply));
	    	return pharmacyList;

    	}
    	//EmptyList.add(new PharmacyMedicineSupply("NA","NA",0));
    	return null;
    
    }

    public Boolean isSessionValid(String token) {
    	try {
    		AuthResponse authResponse = authClient.getValidity(token);
    	} catch (Exception e) {
    		return false;
    	}
    	return true;
    }
    	
   
}

