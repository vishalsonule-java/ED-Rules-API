package com.ashokit.service;

import java.util.Date;

import org.springframework.stereotype.Service;

import com.ashokit.binding.EDRequestBody;
import com.ashokit.binding.EDResponseBody;

@Service
public class EDRulesServiceImpl implements EDRulesService {

	@Override
	public EDResponseBody determineElibility(EDRequestBody body) {

		EDResponseBody resBody= new EDResponseBody();
		resBody.setCaseNumber(body.getCaseNumber());
		resBody.setPlanName(body.getPlanName());
		
		if(body.getPlanName().equalsIgnoreCase("SNAP")&& !body.getIsEmployed()) {
			resBody.setBenefitAmt(220.0);
			resBody.setStartDate(new Date());
			resBody.setEndDate(new Date());
			resBody.setPlanStatus("AP");
		}
		else if(body.getPlanName().equalsIgnoreCase("SNAP")&& body.getIsEmployed()) {
			
			resBody.setPlanStatus("DN");
			resBody.setDenialReason("Citizen is Employee");
		}
		else if(body.getPlanName().equalsIgnoreCase("CCAP") && body.getKidsCount()<=0) {
			resBody.setPlanStatus("DN");
			resBody.setDenialReason("No Childrans");
		}
		else if(body.getPlanName().equalsIgnoreCase("CCAP") && body.getKidsCount()>=1) {
			resBody.setBenefitAmt(500.0);
			resBody.setStartDate(new Date());
			resBody.setEndDate(new Date());
			resBody.setPlanStatus("AP");
		}
		else if(body.getPlanName().equalsIgnoreCase("RIW") && body.getIsGraduate()) {
			resBody.setBenefitAmt(300.0);
			resBody.setStartDate(new Date());
			resBody.setEndDate(new Date());
			resBody.setPlanStatus("AP");
		}
		else if(body.getPlanName().equalsIgnoreCase("RIW") && !body.getIsGraduate()) {
			resBody.setPlanStatus("DN");
			resBody.setDenialReason("Under graduate");
		}
		return resBody;
	}

}
