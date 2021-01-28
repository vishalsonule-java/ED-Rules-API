package com.ashokit.binding;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;

@Data
public class ResponseBody implements Serializable {

	private static final long serialVersionUID = 7291745843649378993L;
	
	private String caseNumber;
	private String planName;
	private String planStatus;
	private  Date startDate;
	private Date endDate;
	private Double benefitAmt;
	private String denialReason;

}
