package com.example.ownablebackenddevelopment.resources.model.request;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

public class LoginRequest implements Serializable {
    private static final long serialVersionUID = 1L;

   @NotBlank
    private String email;

   @NotBlank
    private String password;


    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

}
