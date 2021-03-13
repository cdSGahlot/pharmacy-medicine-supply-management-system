package com.cognizant.pharmacymanagement.WebPortal.FeignClient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.cognizant.pharmacymanagement.WebPortal.Model.AuthResponse;
import com.cognizant.pharmacymanagement.WebPortal.Model.UserData;



@FeignClient(name = "authorization-service", url = "http://localhost:9095")
public interface AuthClient {

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public UserData login(@RequestBody UserData userlogincredentials);

	@RequestMapping(value = "/validate", method = RequestMethod.GET)
	public AuthResponse getValidity(@RequestHeader("Authorization") String token);

}
