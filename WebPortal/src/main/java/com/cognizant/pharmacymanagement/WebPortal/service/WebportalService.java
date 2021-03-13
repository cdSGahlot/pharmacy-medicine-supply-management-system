package com.cognizant.pharmacymanagement.WebPortal.service;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;

import com.cognizant.pharmacymanagement.WebPortal.FeignClient.AuthClient;
import com.cognizant.pharmacymanagement.WebPortal.Model.AuthResponse;
import com.cognizant.pharmacymanagement.WebPortal.Model.UserData;



@Service
public class WebportalService {
	
	@Autowired
	private AuthClient authClient;

	public String postLogin(UserData user, HttpSession session, ModelMap warning) {

		UserData res = null;
		try {
			res = authClient.login(user);
		} catch (Exception e) {
			String errmsg = "";
			if (e.getClass().toString().contains("feign.RetryableException"))
				errmsg = "Site is Temporarily down. Try again later.";
			else
				errmsg = "Unable to login. please check your credentials.";
			warning.addAttribute("errormsg", errmsg);
			return "login";
		}
		session.setAttribute("token", "Bearer " + res.getAuthToken());
		session.setAttribute("memberId", res.getUserid());
		return getHomePage((String) session.getAttribute("token"));
	}
	
	public String getHomePage(String token) {

		try {
			AuthResponse authResponse = authClient.getValidity(token);
		} catch (Exception e) {
			return "redirect:/";
		}
		return "Home";

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
