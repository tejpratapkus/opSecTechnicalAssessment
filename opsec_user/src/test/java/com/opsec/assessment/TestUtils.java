package com.opsec.assessment;

import com.opsec.assessment.entity.UserEntity;
import com.opsec.assessment.request.UserRequest;
import com.opsec.assessment.response.UserResponse;

import java.util.Date;

/**
 * This class is used to create default object which will be used at the time of testing
 *
 * @author tkushwaha
 *
 */
public class TestUtils {

    /**
     * This method is used to handle method argument is not valid
     */
    public static UserEntity getUserEntity() {
        UserEntity entity = new UserEntity();
        entity.setFirstName("tej");
        entity.setSurName("pratap");
        entity.setDob(new Date());
        entity.setTitle("Mr.");
        return entity;
    }

    /**
     * This method is used to handle method argument is not valid
     */
    public static UserRequest getUserRequest() {
        UserRequest request = new UserRequest();
        request.setFirstName("tej");
        request.setSurName("pratap");
        request.setDob(new Date());
        request.setTitle("Mr.");
        return request;
    }

    /**
     * This method is used to handle method argument is not valid
     */
    public static UserResponse getUserResponse() {
        UserResponse response = new UserResponse();
        response.setId("1");
        response.setFirstName("tej");
        response.setSurName("pratap");
        response.setDob(new Date());
        response.setTitle("Mr.");
        return response;
    }

}
