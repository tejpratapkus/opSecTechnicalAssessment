package com.opsec.assessment.request;

import java.util.Date;

import javax.validation.constraints.NotEmpty;

import lombok.Data;

/**
 * @author tkushwaha
 *
 */
@Data
public class UserRequest {

	@NotEmpty(message = "firstName Cannot be null/Blank")
	private String firstName;
	@NotEmpty(message = "surName Cannot be null/Blank")
	private String surName;
	private Date dob;
	private String title;

}
