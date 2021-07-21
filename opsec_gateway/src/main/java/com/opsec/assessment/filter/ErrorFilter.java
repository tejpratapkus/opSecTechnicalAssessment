package com.opsec.assessment.filter;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;

/**
 * This class is used to generate log, filters run if an error occurs in the course of handling the request.
 *
 * @author tkushwaha
 *
 */
@Component
public class ErrorFilter extends ZuulFilter {

	private static Logger log = LoggerFactory.getLogger(ErrorFilter.class);

	@Override
	public String filterType() {
		return "error";
	}

	@Override
	public int filterOrder() {
		return 1;
	}

	@Override
	public boolean shouldFilter() {
		return false;
	}

	@Override
	public Object run() throws ZuulException {
		RequestContext ctx = RequestContext.getCurrentContext();
		HttpServletRequest request = ctx.getRequest();

		log.info("Error-filter "
				+ String.format("%s request to %s", request.getMethod(), request.getRequestURL().toString()));

		return null;
	}

}
