package com.opsec.assessment.mapper;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;

/**
 * @author tkushwaha
 *
 */
public class Mapper {

	/**
	 * Inner class is used to create ModelMapper object
	 *
	 */
	private static class Instance {

		public static final ModelMapper INSTANCE = new ModelMapper();

	}

	/**
	 * Inner method is used to return ModelMapper object
	 *
	 */
	public static ModelMapper getInstance() {
		Instance.INSTANCE.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		return Instance.INSTANCE;
	}
}
