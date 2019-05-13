package edu.mum.waa.controller;

import edu.mum.waa.request.LoginRequest;
import edu.mum.waa.response.LoginResponse;
import edu.mum.waa.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping(value = "/login")
    public LoginResponse login(@RequestBody LoginRequest loginRequest) {
        return userService.login(loginRequest);
    }
}
