package com.example.demo.service;

import com.example.demo.data.UserEntity;
import com.example.demo.data.UserRepository;
import com.example.demo.shared.UserDto;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {

    UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDto createUser(UserDto userDetail) {
        userDetail.setUserId(UUID.randomUUID().toString());

        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        UserEntity userEntity = modelMapper.map(userDetail, UserEntity.class);
        userEntity.setEncryptedPassword("test");

        userRepository.save(userEntity);

        UserDto createdUser = modelMapper.map(userEntity, UserDto.class);
        return createdUser;
    }
}
