package com.opsec.assessment.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.opsec.assessment.entity.UserEntity;

/**
 * @author tkushwaha
 *
 */
@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {

}
