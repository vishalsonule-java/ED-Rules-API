package com.ashokit.binding;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;

@Data
public class EDRequestBody implements Serializable {

	private static final long serialVersionUID = -6849704253998966301L;
	
	private String caseNumber;
	private String firstName;
	private String lastName;
	private Date dob;
	private String gender;
	private String planName;
	private Boolean isEmployed;
	private Double income;
	private Integer kidsCount;
	private Boolean isGraduate;

}
