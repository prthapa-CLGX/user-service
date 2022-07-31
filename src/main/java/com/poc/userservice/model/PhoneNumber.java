package com.poc.userservice.model;

import org.springframework.stereotype.Component;

import lombok.Data;

@Component
@Data
public class PhoneNumber {
    private String cellPhone;
    private String workPhone;
}
