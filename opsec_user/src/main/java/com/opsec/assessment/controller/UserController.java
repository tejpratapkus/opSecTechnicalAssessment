package com.opsec.assessment.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.opsec.assessment.request.UserRequest;
import com.opsec.assessment.response.ApplicationResponse;
import com.opsec.assessment.service.IUserService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * This controller used to create, update and get user information
 * 
 * @author tkushwaha
 *
 */
@RestController
@RequestMapping("/v1")
@Api(tags = "opsec-assessment")
public class UserController {

	@Autowired
	private IUserService service;

	/**
	 * This method is used to create user information
	 * 
	 * @param request
	 * @return ApplicationResponse
	 * 
	 */
	@PostMapping("/user")
	@ApiOperation(value = "Create User", nickname = "Create User", httpMethod = "POST", consumes = MediaType.APPLICATION_JSON_VALUE, response = ApplicationResponse.class)
	public ResponseEntity<ApplicationResponse> createUser(@Valid @RequestBody UserRequest request) {
		ApplicationResponse response = service.createUser(request);
		return ResponseEntity.status(HttpStatus.CREATED).body(response);

	}

	/**
	 * This method is used to get user information on the basis of id you provide,
	 * if not provided the id it will return all user
	 * 
	 * @param id
	 * @return ApplicationResponse
	 * 
	 */
	@GetMapping("/user")
	@ApiOperation(value = "Get User", nickname = "Get User", httpMethod = "GET", consumes = MediaType.APPLICATION_JSON_VALUE, response = ApplicationResponse.class)
	public ResponseEntity<ApplicationResponse> getUsers(@RequestParam(value = "id", required = false) String id) {
		ApplicationResponse response = service.getUsers(id);
		return ResponseEntity.ok().body(response);
	}

	/**
	 * This method is used to update user information on the basis of id
	 * 
	 * @param id
	 * @param request
	 * @return ApplicationResponse
	 * 
	 */
	@PutMapping("/user/{id}")
	@ApiOperation(value = "Update User", nickname = "Update User", httpMethod = "PUT", consumes = MediaType.APPLICATION_JSON_VALUE, response = ApplicationResponse.class)
	public ResponseEntity<ApplicationResponse> updateUser(@PathVariable("id") String id,
			@Valid @RequestBody UserRequest request) {
		ApplicationResponse response = service.updateUser(id, request);
		return ResponseEntity.ok().body(response);
	}

	/**
	 * This method is used to delete user information on the basis of id
	 * 
	 * @param id
	 * @return ApplicationResponse
	 * 
	 */
	@DeleteMapping("/user/{id}")
	@ApiOperation(value = "Delete User", nickname = "Delete User", httpMethod = "DELETE", consumes = MediaType.APPLICATION_JSON_VALUE, response = ApplicationResponse.class)
	public ResponseEntity<ApplicationResponse> deleteUser(@PathVariable("id") String id) {
		ApplicationResponse response = service.deleteUser(id);
		return ResponseEntity.ok().body(response);

	}

}
