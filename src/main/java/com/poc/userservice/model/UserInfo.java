package com.poc.userservice.model;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserInfo {
    private int userId;
    private String userName;
    private String userJob;
    private Address address;
    private PhoneNumber phoneNumber;

}
