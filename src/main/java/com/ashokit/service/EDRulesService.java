package com.ashokit.service;

import com.ashokit.binding.EDRequestBody;
import com.ashokit.binding.EDResponseBody;

public interface EDRulesService {

	public EDResponseBody determineElibility(EDRequestBody body);
}
