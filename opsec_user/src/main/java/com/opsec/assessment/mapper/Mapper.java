package com.opsec.assessment.mapper;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;

/**
 * @author tkushwaha
 *
 */
public class Mapper {

	private static class Instance {

		public static final ModelMapper INSTANCE = new ModelMapper();

	}

	public static ModelMapper getInstance() {
		Instance.INSTANCE.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		return Instance.INSTANCE;
	}
}
