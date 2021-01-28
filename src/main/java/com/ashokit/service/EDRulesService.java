package com.ashokit.service;

import com.ashokit.binding.RequestBody;
import com.ashokit.binding.ResponseBody;

public interface EDRulesService {

	public ResponseBody determineElibility(RequestBody body);
}
