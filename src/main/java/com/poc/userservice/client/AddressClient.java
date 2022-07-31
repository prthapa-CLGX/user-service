package com.poc.userservice.client;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.poc.userservice.model.Address;
import com.poc.userservice.model.User;

@FeignClient(url = "http://address-service:9999", name = "Address-service")
public interface AddressClient {

    @PostMapping("/address")
    Address getAddressOfAUser(@RequestBody User.Key key);
}
