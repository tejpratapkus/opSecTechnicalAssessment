package com.opsec.assessment.response;

import java.util.Date;

import lombok.Data;

@Data
public class UserResponse {

	private Long id;
	private String firstName;
	private String surName;
	private Date dob;
	private String title;
}
