package com.opsec.assessment;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Date;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.web.client.RestTemplate;

import com.opsec.assessment.request.UserRequest;
import com.opsec.assessment.response.ApplicationResponse;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class UserControllerTest {

	@LocalServerPort
	private int port;

	private String baseUrl = "http://localhost";

	private static RestTemplate restTemplate = null;

	@BeforeAll
	public static void init() {
		restTemplate = new RestTemplate();
	}

	@BeforeEach
	public void setUp() {
		baseUrl = baseUrl.concat(":").concat(port + "").concat("/v1/user");
	}

	@Test
	@Sql(statements = "INSERT INTO users(id, first_name, sur_name, dob, title) VALUES (1, 'Tej', 'pratap', '1992-04-11', 'Mr.')", executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
	@Sql(statements = "DELETE FROM users", executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)
	public void returnAUserWithIdOne() {

		ResponseEntity<ApplicationResponse> responseEntity = restTemplate.getForEntity(baseUrl.concat("?id=1"),
				ApplicationResponse.class);

		assertEquals(true, responseEntity.getBody().isStatus());

	}

	@Test
	@Sql(statements = "INSERT INTO users(id, first_name, sur_name, dob, title) VALUES (1, 'Tej', 'pratap', '1992-04-11', 'Mr.')", executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
	@Sql(statements = "INSERT INTO users(id, first_name, sur_name, dob, title) VALUES (2, 'Tejpratap', 'Kushawaha', '1995-04-11', 'Mr.')", executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
	@Sql(statements = "DELETE FROM users", executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)
	public void returnAllUser() {

		ResponseEntity<ApplicationResponse> responseEntity = restTemplate.getForEntity(baseUrl,
				ApplicationResponse.class);

		assertEquals(true, responseEntity.getBody().isStatus());

	}

	@Test
	@Sql(statements = "INSERT INTO users(id, first_name, sur_name, dob, title) VALUES (1, 'Tej', 'pratap', '1992-04-11', 'Mr.')", executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
	@Sql(statements = "DELETE FROM users", executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)
	public void deleteUser() {

		ResponseEntity<ApplicationResponse> responseEntity = restTemplate.exchange(baseUrl.concat("/1"),
				HttpMethod.DELETE, null, ApplicationResponse.class);

		assertEquals(true, responseEntity.getBody().isStatus());

	}
	
	@Test
	@Sql(statements = "INSERT INTO users(id, first_name, sur_name, dob, title) VALUES (1, 'Tej', 'pratap', '1992-04-11', 'Mr.')", executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
	@Sql(statements = "DELETE FROM users", executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)
	public void updateUser() {
		
		UserRequest request = new UserRequest();
		request.setFirstName("Tejpratap");
		request.setSurName("Kushawaha");
		request.setDob(new Date());
		request.setTitle("Mr.");
		HttpEntity httpEntity = new HttpEntity(request);
		ResponseEntity<ApplicationResponse> responseEntity = restTemplate.exchange(baseUrl.concat("/1"),
				HttpMethod.PUT, httpEntity, ApplicationResponse.class);

		assertEquals(true, responseEntity.getBody().isStatus());

	}
	
	@Test
	@Sql(statements = "DELETE FROM users", executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)
	public void createUser() {
		
		UserRequest request = new UserRequest();
		request.setFirstName("Tejpratap");
		request.setSurName("Kushawaha");
		request.setDob(new Date());
		request.setTitle("Mr.");
		HttpEntity httpEntity = new HttpEntity(request);
		ResponseEntity<ApplicationResponse> responseEntity = restTemplate.exchange(baseUrl,
				HttpMethod.POST, httpEntity, ApplicationResponse.class);

		assertEquals(true, responseEntity.getBody().isStatus());

	}
	
	@Test
	@Sql(statements = "INSERT INTO users(id, first_name, sur_name, dob, title) VALUES (1, 'Tej', 'pratap', '1992-04-11', 'Mr.')", executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
	@Sql(statements = "DELETE FROM users", executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)
	public void userNotFound() {

		ResponseEntity<ApplicationResponse> responseEntity = restTemplate.getForEntity(baseUrl.concat("?id=2"),
				ApplicationResponse.class);

		assertEquals(false, responseEntity.getBody().isStatus());

	}

}
