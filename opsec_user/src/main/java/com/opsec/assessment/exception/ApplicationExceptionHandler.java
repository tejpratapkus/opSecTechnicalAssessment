package com.opsec.assessment.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.servlet.NoHandlerFoundException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.opsec.assessment.response.ApplicationResponse;

/**
 * This class is used the return customized exception, if any exception occurred
 * at runtime
 * 
 * @author tkushwaha
 *
 */
@ControllerAdvice
public class ApplicationExceptionHandler extends ResponseEntityExceptionHandler {

	/**
	 * This method is used to handle method argument is not valid
	 * 
	 * @param ex
	 * @param headers
	 * @param status
	 * @param request
	 * @return Object
	 * 
	 */
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		StringBuilder errors = new StringBuilder();
		ApplicationResponse response = new ApplicationResponse();
		ex.getBindingResult().getAllErrors().forEach((error) -> {
			if (!StringUtils.isEmpty(errors)) {
				errors.append(", ");
			}
			errors.append(error.getDefaultMessage());
		});
		response.setMessage(errors.toString());
		response.setStatus(false);
		return ResponseEntity.badRequest().body(response);
	}

	/**
	 * This method is used to handle missing servlet request parameter
	 * 
	 * @param ex
	 * @param headers
	 * @param status
	 * @param request
	 * @return Object
	 * 
	 */
	@Override
	protected ResponseEntity<Object> handleMissingServletRequestParameter(MissingServletRequestParameterException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		String error = ex.getParameterName() + " parameter is missing";
		ApplicationResponse response = new ApplicationResponse();
		response.setMessage(error);
		response.setStatus(false);
		return ResponseEntity.badRequest().body(response);
	}

	/**
	 * This method is used handle method argument type is mismatch
	 * 
	 * @param ex
	 * @param request
	 * @return Object
	 * 
	 */
	@ExceptionHandler({ MethodArgumentTypeMismatchException.class })
	public ResponseEntity<Object> handleMethodArgumentTypeMismatch(MethodArgumentTypeMismatchException ex,
			WebRequest request) {
		String error = ex.getName() + " should be of type " + ex.getRequiredType().getName();
		ApplicationResponse response = new ApplicationResponse();
		response.setMessage(error);
		response.setStatus(false);
		return ResponseEntity.badRequest().body(response);
	}

	/**
	 * This method is used to handle no handler found exception
	 * 
	 * @param ex
	 * @param headers
	 * @param status
	 * @param request
	 * @return Object
	 * 
	 */
	@Override
	protected ResponseEntity<Object> handleNoHandlerFoundException(NoHandlerFoundException ex, HttpHeaders headers,
			HttpStatus status, WebRequest request) {
		String error = "No handler found for " + ex.getHttpMethod() + " " + ex.getRequestURL();
		ApplicationResponse response = new ApplicationResponse();
		response.setMessage(error);
		response.setStatus(false);
		return ResponseEntity.badRequest().body(response);
	}

}
