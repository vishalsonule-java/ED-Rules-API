package com.ashokit.rest;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ashokit.binding.ResponseBody;

@RestController
public class EDRulesRestController {
	
	@PostMapping("/findPlanElgi")
	public ResponseEntity<ResponseBody> handleEligiblityDeterminationButton(@RequestBody com.ashokit.binding.RequestBody body){
		ResponseBody resbody=new ResponseBody();
		resbody.setCaseNumber("101");
		resbody.setBenefitAmt(5555.05);
		resbody.setPlanName("SNAP");
		resbody.setPlanStatus("AP");
		resbody.setStartDate(new Date());
		resbody.setEndDate(new Date());
		return new ResponseEntity<ResponseBody>(resbody,HttpStatus.OK);
	}


}
