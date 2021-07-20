package com.opsec.assessment.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.opsec.assessment.entity.UserEntity;
import com.opsec.assessment.repository.UserRepository;
import com.opsec.assessment.request.UserRequest;
import com.opsec.assessment.response.ApplicationResponse;
import com.opsec.assessment.response.UserResponse;
import com.opsec.assessment.service.IUserService;

/**
 * This is the service layer of user
 * 
 * @author tkushwaha
 *
 */
@Service
public class UserService implements IUserService {

	@Autowired
	private UserRepository repository;

	/**
	 * This method is used to create user information record inside database
	 * 
	 * @param request
	 * @return ApplicationResponse
	 * 
	 */
	@Override
	public ApplicationResponse createUser(UserRequest request) {
		UserEntity entity = repository.save(modeltoentity.apply(request));
		if (entity != null) {
			return new ApplicationResponse(true, "Success", enitytomodel.apply(entity));
		}
		return new ApplicationResponse(false, "Failure", enitytomodel.apply(entity));
	}

	/**
	 * This method is used to get user information from db on the basis of id you provide,
	 * if not provided the id it will retrieve all users
	 * 
	 * @param id
	 * @return ApplicationResponse
	 * 
	 */
	@Override
	public ApplicationResponse getUsers(String id) {

		List<UserResponse> responses = new ArrayList<>();
		if (!StringUtils.isEmpty(id)) {
			Optional<UserEntity> userEntity = repository.findById(id);
			if (userEntity.isPresent()) {
				UserEntity user = userEntity.get();
				UserResponse response = enitytomodel.apply(user);
				responses.add(response);
				return new ApplicationResponse(true, "Success", responses);
			}
		} else {
			List<UserEntity> list = repository.findAll();
			if (list.size() > 0) {
				for (UserEntity user : list) {
					UserResponse response = enitytomodel.apply(user);
					responses.add(response);
				}
				return new ApplicationResponse(true, "Success", responses);
			}
		}
		return new ApplicationResponse(false, "Failure", null);
	}

	/**
	 * This method is used to update user information inside db on the basis of id
	 * 
	 * @param id
	 * @param request
	 * @return ApplicationResponse
	 * 
	 */
	@Override
	public ApplicationResponse updateUser(String id, UserRequest request) {
		UserEntity user = null;
		Optional<UserEntity> userEntity = repository.findById(id);
		if (userEntity.isPresent()) {
			user = userEntity.get();
			if (!StringUtils.isEmpty(request.getFirstName())) {
				user.setFirstName(request.getFirstName());
			}
			if (!StringUtils.isEmpty(request.getSurName())) {
				user.setSurName(request.getSurName());
			}
			if (!StringUtils.isEmpty(request.getDob())) {
				user.setDob(request.getDob());
			}
			if (!StringUtils.isEmpty(request.getTitle())) {
				user.setTitle(request.getTitle());
			}
			user = repository.save(user);
			return new ApplicationResponse(true, "Success", enitytomodel.apply(user));
		}

		return new ApplicationResponse(false, "Failure", enitytomodel.apply(user));
	}

	/**
	 * This method is used to delete user information from db on the basis of id
	 * 
	 * @param id
	 * @return ApplicationResponse
	 * 
	 */
	@Override
	public ApplicationResponse deleteUser(String id) {
		repository.deleteById(id);
		return new ApplicationResponse(true, "Success", null);
	}

}
