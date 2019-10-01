package com.mkyong.domain;

import lombok.*;

@Getter
@Setter
public class UserDto {
    private String username;
    private String password;
    private String fullname;
    private String street;
    private String city;
    private String state;
    private String zip;
    private String phone;
}
