package com.opsec.assessment.service;

import java.util.function.Function;

import com.opsec.assessment.entity.UserEntity;
import com.opsec.assessment.mapper.Mapper;
import com.opsec.assessment.request.UserRequest;
import com.opsec.assessment.response.ApplicationResponse;
import com.opsec.assessment.response.UserResponse;

/**
 * @author tkushwaha
 *
 */
public interface IUserService {

	ApplicationResponse createUser(UserRequest request);

	ApplicationResponse getUsers(String id);

	ApplicationResponse updateUser(String id, UserRequest request);

	ApplicationResponse deleteUser(String id);

	/**
	 * This method is used to return UserEntity object from UserRequest object
	 * 
	 * @param request
	 * @return UserEntity
	 * 
	 */
	static UserEntity modelToEntity(UserRequest request) {
		if (request == null)
			return new UserEntity();
		return Mapper.getInstance().map(request, UserEntity.class);
	}

	/**
	 * This method is used to return user response object from user entity object
	 * 
	 * @param entity
	 * @return UserResponse
	 * 
	 */
	static UserResponse enityToModel(UserEntity entity) {
		if (entity == null)
			return new UserResponse();
		return Mapper.getInstance().map(entity, UserResponse.class);
	}

	Function<UserRequest, UserEntity> modeltoentity = (dto) -> modelToEntity(dto);

	Function<UserEntity, UserResponse> enitytomodel = (entity) -> enityToModel(entity);

}
