package com.opsec.assessment.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
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
