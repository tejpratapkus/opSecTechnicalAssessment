package com.opsec.assessment.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.opsec.assessment.entity.UserEntity;

/**
 * This repository is used to handle UserEntity entire process
 *
 * @author tkushwaha
 *
 */
@Repository
public interface UserRepository extends MongoRepository<UserEntity, String> {

}
