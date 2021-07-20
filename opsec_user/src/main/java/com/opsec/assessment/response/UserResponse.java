package com.opsec.assessment.response;

import java.util.Date;

import lombok.Data;

@Data
public class UserResponse {

	private String id;
	private String firstName;
	private String surName;
	private Date dob;
	private String title;
}
