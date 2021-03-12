package com.cognizant.pharmacymanagement.MedicinesSupply.model;
import java.util.*;

public class PharmacyList {
	private static ArrayList<String> pharmList = new ArrayList<String>();
	private static int mark = 0;
	static{
		
		pharmList.add("MedCity");
		pharmList.add("Med 7");
		pharmList.add("PharmaOne");
		pharmList.add("MediLane");
		pharmList.add("Pharma Plus");
		
		}
	
	public static String retrieveNames() {
		int m = mark;
		if(++mark==5)
			mark=0;
		return pharmList.get(m);
	}
	}
//public String getPharmacies() {
	//for (int i = 0; i < pharmList.size(); i++) 
		//return (pharmList.get(i)); 
	//}
	


