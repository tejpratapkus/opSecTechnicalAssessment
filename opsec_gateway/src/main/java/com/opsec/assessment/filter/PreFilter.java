package com.opsec.assessment.filter;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;

/**
 * This class is used to generate log, filters run before the request is routed
 *
 * @author tkushwaha
 *
 */
@Component
public class PreFilter extends ZuulFilter {

	private static Logger log = LoggerFactory.getLogger(PreFilter.class);

	@Override
	public String filterType() {
		return "pre";
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

		log.info("Pre-filter "
				+ String.format("%s request to %s", request.getMethod(), request.getRequestURL().toString()));

		return null;
	}

}
