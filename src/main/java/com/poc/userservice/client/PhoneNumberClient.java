package com.poc.userservice.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.poc.userservice.model.PhoneNumber;
import com.poc.userservice.model.User;

@FeignClient(url = "http://phonenumber-service:9997", name = "phoneNumber-service")
public interface PhoneNumberClient {

    @PostMapping("/phone")
    PhoneNumber getPhoneNumberForUser(@RequestBody User.Key key);
}
