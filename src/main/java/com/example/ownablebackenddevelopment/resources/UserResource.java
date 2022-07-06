package com.example.ownablebackenddevelopment.resources;

import com.example.ownablebackenddevelopment.domain.User;
import com.example.ownablebackenddevelopment.resources.model.UserRequest;
import com.example.ownablebackenddevelopment.resources.model.UserResponse;
import com.example.ownablebackenddevelopment.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@RestController
@RequestMapping("/api")
public class UserResource {

    private final Logger logger = LoggerFactory.getLogger(UserResource.class);

    private UserService userService;


    public UserResource ( UserService userService ) {
        this.userService = userService;
    }

   /* @GetMapping("")
    ResponseEntity<Set<UserResponse>> findAllUser() {
        return ResponseEntity.ok(userService.findAllUser());
    }*/

    @GetMapping("")
    public String viewHomePage() {
        return "index";
    }

    @GetMapping("/register")
    public String showRegistration(Model model) {
        model.addAttribute("user", new User());
        return "signup_form";
    }

    @PostMapping("/process_register")
    public ResponseEntity<UserResponse> processRegister(UserRequest userRequest) {
        logger.debug("The REST API to save user {}", userRequest);
        var response = userService.saveUser(userRequest);

        return ResponseEntity.ok(response.get());
    }
}
