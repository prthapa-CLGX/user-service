package com.poc.userservice.model;

import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@Component
public class Address {
    private String streetNameAndNumber;
    private String city;
    private String State;
}
