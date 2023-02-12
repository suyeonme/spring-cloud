package com.example.demo.ui.controllers;

import com.example.demo.service.UserService;
import com.example.demo.shared.UserDto;
import com.example.demo.ui.model.CreateUserRequestModel;
import com.example.demo.ui.model.CreateUserResponseModel;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    UserService userService;

//    @GetMapping("/status/check")
//    static String status() {
//        return "User Status working";
//    }

    @PostMapping
    public ResponseEntity<CreateUserResponseModel> createUser(@Valid @RequestBody CreateUserRequestModel userDetail) {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        UserDto userDto = modelMapper.map(userDetail, UserDto.class);

        UserDto createdUser = userService.createUser(userDto);
        CreateUserResponseModel user = modelMapper.map(createdUser, CreateUserResponseModel.class);

        return ResponseEntity.status(HttpStatus.CREATED).body(user);
    }
}
