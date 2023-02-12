package com.example.demo.shared;

import lombok.Getter;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;

@Getter @Setter
public class UserDto implements Serializable {
    @Serial
    private static final long serialVersionUID = -4319847277576012423L;

    private String firstName;
    private String lastName;
    private String password;
    private String email;
    private String userId;
    private String encryptedPassword;
}
