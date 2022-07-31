package com.poc.userservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.poc.userservice.client.AddressClient;
import com.poc.userservice.client.PhoneNumberClient;
import com.poc.userservice.model.User;
import com.poc.userservice.model.UserInfo;
import com.poc.userservice.service.UserService;

@RestController
public class UserController {

    @Autowired
    AddressClient addressClient;

    @Autowired
    PhoneNumberClient phoneNumberClient;

    @Autowired
    UserService userService;

    @PostMapping("/user-address")
    public UserInfo getAddressForAUser(@RequestBody User.Key key) {
        UserInfo userInfo = new UserInfo();
        userInfo.setUserId(key.getUserId());
        userInfo.setUserName(key.getName());
        userInfo.setAddress(addressClient.getAddressOfAUser(key));
        return userInfo;
    }

    @PostMapping("/user-phone")
    public UserInfo getPhoneForAUser(@RequestBody User.Key key) {
        UserInfo userInfo = new UserInfo();
        userInfo.setUserId(key.getUserId());
        userInfo.setUserName(key.getName());
        userInfo.setPhoneNumber(phoneNumberClient.getPhoneNumberForUser(key));
        return userInfo;
    }

    @PostMapping("/user-job")
    public User getUser(@RequestBody User.Key key) {
        return userService.getUserById(key);
    }
}
