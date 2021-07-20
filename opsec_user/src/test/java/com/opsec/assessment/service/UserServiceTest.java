package com.opsec.assessment.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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

@SpringBootTest
public class UserServiceTest {

    @InjectMocks
    private UserService service;
    @Mock
    private UserRepository repository;

    @Test
    void test_createUser() {

        ApplicationResponse response = null;
        Mockito.when(repository.save(TestUtils.getUserEntityForSave())).thenReturn(TestUtils.getUserEntity());
        response = service.createUser(TestUtils.getUserRequest());
        assertEquals(true, response.isStatus());
    }

    @Test
    void test_getUserById() {

        ApplicationResponse response = null;
        Optional<UserEntity> userEntity = Optional.of(TestUtils.getUserEntity());
        Mockito.when(repository.findById("1")).thenReturn(userEntity);
        response = service.getUsers("1");
        assertEquals(true, response.isStatus());
    }

    @Test
    void test_getUsers() {

        ApplicationResponse response = null;
        List<UserEntity> list = new ArrayList<>();
        list.add(TestUtils.getUserEntity());
        Mockito.when(repository.findAll()).thenReturn(list);
        response = service.getUsers(null);
        assertEquals(true, response.isStatus());
    }

    @Test
    void test_getUsersFalse() {

        ApplicationResponse response = null;
        List<UserEntity> list = new ArrayList<>();
        Mockito.when(repository.findAll()).thenReturn(list);
        response = service.getUsers(null);
        assertEquals(false, response.isStatus());
    }

    @Test
    void test_updateUser() {

        ApplicationResponse response = null;
        Optional<UserEntity> userEntity = Optional.of(TestUtils.getUserEntity());
        Mockito.when(repository.findById("1")).thenReturn(userEntity);
        Mockito.when(repository.save(TestUtils.getUserEntity())).thenReturn(TestUtils.getUserEntity());
        response = service.updateUser("1", TestUtils.getUserRequest());
        assertEquals(true, response.isStatus());
    }

    @Test
    void test_deleteUser() {

        ApplicationResponse response = null;
        Mockito.doNothing().when(repository).deleteById("1");
        response = service.deleteUser("1");
        assertEquals(true, response.isStatus());
    }

}
