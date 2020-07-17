package com.mastercard.routerfinder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/connected")
@AllArgsConstructor(onConstructor = @__({ @Autowired }))
public class RouteController {

	@RequestMapping(params = {"origin", "destination"}, path = {""}, 
			method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody String showMessage(
			@RequestParam(value = "origin", required = false) String origin,
			@RequestParam(value = "destination", required = false) String destination) {
		System.out.println("in controller");
		return "Status of Route between "+ origin + " and "+ destination;
	}

	@RequestMapping("/")
	public String home() {
		return "Spring boot is working!";
	}


}
