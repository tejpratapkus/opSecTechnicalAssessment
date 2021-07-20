package com.opsec.assessment.entity;

import java.util.Date;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @author tkushwaha
 *
 */
@Data
@Document(collection = "users")
public class UserEntity {

	@Id
	private String id;
	private String firstName;
	private String surName;
	private Date dob;
	private String title;

}
