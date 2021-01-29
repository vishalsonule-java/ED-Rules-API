package com.ashokit.util;


import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

import org.drools.compiler.compiler.DroolsParserException;
import org.drools.compiler.compiler.PackageBuilder;
import org.drools.core.RuleBase;
import org.drools.core.RuleBaseFactory;
import org.drools.core.WorkingMemory;
import org.drools.core.rule.Package;
import org.springframework.stereotype.Component;

import com.ashokit.binding.EDRequestBody;
import com.ashokit.binding.EDResponseBody;

@Component
public class DroolUtil {

	public EDResponseBody exceuteDrools(EDRequestBody body) throws DroolsParserException, IOException {
		EDResponseBody response= new EDResponseBody();
		String drlFileName=null;
		if(body.getPlanName().equalsIgnoreCase("SNAP")) {
			drlFileName="/com/rule/SNAPRules.drl";
		}

		if(body.getPlanName().equalsIgnoreCase("CCAP")) {
			drlFileName="/com/rule/CCAPRules.drl";
		}

		if(body.getPlanName().equalsIgnoreCase("RIW")) {
			drlFileName="/com/rule/RIWRules.drl";
		}
		
			
			response.setPlanName(body.getPlanName());
			response.setCaseNumber(body.getCaseNumber());
			
			
			InputStream resourceAsStream = getClass().getResourceAsStream(drlFileName);
			Reader reader = new InputStreamReader(resourceAsStream);
			
			PackageBuilder packageBuilder= new PackageBuilder();
			packageBuilder.addPackageFromDrl(reader);
			
			Package rulesPackage = packageBuilder.getPackage();
			RuleBase ruleBase = RuleBaseFactory.newRuleBase();
			ruleBase.addPackage(rulesPackage);

			WorkingMemory workingMemory = ruleBase.newStatefulSession();
			workingMemory.insert(body);
			workingMemory.setGlobal("response", response);
			workingMemory.fireAllRules();
		
		return response;
	}
}
