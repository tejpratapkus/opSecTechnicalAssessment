package com.opsec.assessment.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.opsec.assessment.response.UserResponse;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import com.opsec.assessment.TestUtils;
import com.opsec.assessment.entity.UserEntity;
import com.opsec.assessment.repository.UserRepository;
import com.opsec.assessment.response.ApplicationResponse;
import com.opsec.assessment.service.impl.UserService;

/**
 * This class is used to write the test cases for user service
 *
 * @author tkushwaha
 *
 */
@SpringBootTest
public class UserServiceTest {

    @InjectMocks
    private UserService service;
    @Mock
    private UserRepository repository;

    /**
     * This method is used to create user on the basis of request provided and validate the response status and firstName
     */
    @Test
    void test_createUserSuccess() {

        ApplicationResponse response = null;
        UserEntity user = TestUtils.getUserEntity();
        user.setId("1");
        Mockito.when(repository.save(any())).thenReturn(user);
        response = service.createUser(TestUtils.getUserRequest());
        assertEquals(true, response.isStatus());
        UserResponse userResponse = (UserResponse) response.getData();
        assertEquals("tej", userResponse.getFirstName());
    }

    /**
     * This method is used to create user on the basis of request provided and validate the response status and firstName
     */
    @Test
    void test_createUserFailure() {

        ApplicationResponse response = null;
        UserEntity user = TestUtils.getUserEntity();
        user.setId("1");
        Mockito.when(repository.save(user)).thenReturn(user);
        response = service.createUser(TestUtils.getUserRequest());
        assertEquals(false, response.isStatus());
        assertEquals("Failure", response.getMessage());
    }

    /**
     * This method is used to get users on the basis of id providing and validate the response status
     */
    @Test
    void test_getUserById() {

        ApplicationResponse response = null;
        UserEntity user = TestUtils.getUserEntity();
        user.setId("1");
        Optional<UserEntity> userEntity = Optional.of(user);
        Mockito.when(repository.findById("1")).thenReturn(userEntity);
        response = service.getUsers("1");
        assertEquals(true, response.isStatus());
        List<UserResponse> userResponseList = (List<UserResponse>) response.getData();
        UserResponse userResponse = userResponseList.get(0) ;
        assertEquals("tej", userResponse.getFirstName());
    }

    /**
     * This method is used to get users on the basis of id providing and validate the response status
     */
    @Test
    void test_getUsers() {

        ApplicationResponse response = null;
        UserEntity user = TestUtils.getUserEntity();
        user.setId("1");
        List<UserEntity> list = new ArrayList<>();
        list.add(user);
        Mockito.when(repository.findAll()).thenReturn(list);
        response = service.getUsers(null);
        assertEquals(true, response.isStatus());
        List<UserResponse> userResponseList = (List<UserResponse>) response.getData();
        UserResponse userResponse = userResponseList.get(0) ;
        assertEquals("tej", userResponse.getFirstName());
    }

    /**
     * TThis method is used to get users providing and validate the response status
     */
    @Test
    void test_getUsersFalse() {

        ApplicationResponse response = null;
        List<UserEntity> list = new ArrayList<>();
        Mockito.when(repository.findAll()).thenReturn(list);
        response = service.getUsers(null);
        assertEquals(false, response.isStatus());
        assertEquals("Failure", response.getMessage());
    }

    /**
     * This method is used to update users on the basis of id providing and validate the response status
     */
    @Test
    void test_updateUser() {

        ApplicationResponse response = null;
        UserEntity user = TestUtils.getUserEntity();
        user.setId("1");
        Optional<UserEntity> userEntity = Optional.of(user);
        Mockito.when(repository.findById("1")).thenReturn(userEntity);
        Mockito.when(repository.save(user)).thenReturn(user);
        response = service.updateUser("1", TestUtils.getUserRequest());
        assertEquals(true, response.isStatus());
        UserResponse userResponse = (UserResponse) response.getData();
        assertEquals("tej", userResponse.getFirstName());
    }

    /**
     * This method is used to update users on the basis of id providing and validate the response status
     */
    @Test
    void test_updateUserNotFound() {

        ApplicationResponse response = null;
        UserEntity user = TestUtils.getUserEntity();
        user.setId("1");
        Optional<UserEntity> userEntity = Optional.of(user);
        Mockito.when(repository.findById("1")).thenReturn(userEntity);
        Mockito.when(repository.save(user)).thenReturn(user);
        response = service.updateUser("1", TestUtils.getUserRequest());
        assertEquals(true, response.isStatus());
    }

    /**
     * This method is used to delete users on the basis of id providing and validate the response status
     */
    @Test
    void test_deleteUser() {

        ApplicationResponse response = null;
        UserEntity user = TestUtils.getUserEntity();
        user.setId("1");
        Optional<UserEntity> userEntity = Optional.of(user);
        Mockito.when(repository.findById("1")).thenReturn(userEntity);
        Mockito.doNothing().when(repository).deleteById("1");
        response = service.deleteUser("1");
        assertEquals(true, response.isStatus());
    }

}
