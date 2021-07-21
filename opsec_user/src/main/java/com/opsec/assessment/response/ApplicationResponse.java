package com.opsec.assessment.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * This class is used the return response at application level
 *
 * @author tkushwaha
 *
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ApplicationResponse {
	
	private boolean status;
	private String message;
	private Object data;

}
