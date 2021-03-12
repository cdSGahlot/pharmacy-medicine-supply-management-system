package com.cognizant.pharmacymanagement.RepresentativeSchedule.Controller;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.cognizant.pharmacymanagement.RepresentativeSchedule.RepresentativeScheduleApplication;
import com.cognizant.pharmacymanagement.RepresentativeSchedule.Model.RepSchedule;
import com.cognizant.pharmacymanagement.RepresentativeSchedule.Model.UserData;
import com.cognizant.pharmacymanagement.RepresentativeSchedule.Service.RepScheduleService;
import com.cognizant.pharmacymanagement.RepresentativeSchedule.feignClient.StockFeignClient;

@RestController
public class RepSchedController {

	@InitBinder
    public void initBinder(WebDataBinder binder) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        sdf.setLenient(true);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(sdf, true));
    }
	
	private static Logger LOGGER = LoggerFactory.getLogger(RepresentativeScheduleApplication.class);
	
	@Autowired
	UserData admin;
	
	@Autowired
	private RepScheduleService service;
	

		
	@RequestMapping(value ="/viewSchedule", method = RequestMethod.GET)
	public String showDate(@RequestHeader("Authorization") String token) {
		LOGGER.info("Starting showDate");
		//return new ModelAndView("viewSchedule");
		//return new ResponseEntity<>(new ModelAndView("viewSchedule"), HttpStatus.OK);
		if (service.isSessionValid(token)) {
			LOGGER.info("Ending showDate");
			return "viewSchedule";
		}
		LOGGER.info("Ending showDate");
		return "login";
	}
	
	@GetMapping("/RepSchedule")
	public ResponseEntity<?> showSchedule(@RequestHeader("Authorization") String token, @RequestParam String startdate) throws ParseException{    
		//model.put("details",service.returnschedule(startdate));
		LOGGER.info("Starting showschedule");
		if (service.isSessionValid(token)) {	
			LOGGER.info("Ending showschedule");
			return new ResponseEntity<>(service.returnschedule(startdate), HttpStatus.OK);
		}
		LOGGER.info("Ending showSchedule");
		return null;
	}
	
}
