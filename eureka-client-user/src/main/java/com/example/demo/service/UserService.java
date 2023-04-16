package com.example.demo.service;

import com.example.demo.shared.UserDto;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {
    UserDto createUser(UserDto userDetail);
    UserDto getUserDetailsByEmail(String email);
}
