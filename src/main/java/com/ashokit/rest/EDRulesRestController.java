package com.ashokit.rest;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ashokit.binding.EDResponseBody;
import com.ashokit.service.EDRulesService;

@RestController
public class EDRulesRestController {
	
	@Autowired
	private EDRulesService service;
	
	@PostMapping("/findPlanElgi")
	public ResponseEntity<EDResponseBody> handleEligiblityDeterminationButton(@RequestBody com.ashokit.binding.EDRequestBody body){
		EDResponseBody responseBody = service.determineElibility(body);
		return new ResponseEntity<EDResponseBody>(responseBody,HttpStatus.OK);
	}


}
