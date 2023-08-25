package com.example.BTL_INTERNET_GT.Controller;

import com.example.BTL_INTERNET_GT.Auth.AuthenticationRequest;
import com.example.BTL_INTERNET_GT.DTO.UserDTO;
import com.example.BTL_INTERNET_GT.Service.AuthenticationService;
import com.example.BTL_INTERNET_GT.Service.UserService;
import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthenticationController {
    @Autowired
    UserService userService;
    private final AuthenticationService authenticationService;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody AuthenticationRequest authenticationRequest){
        return ResponseEntity.ok(authenticationService.authenticate(authenticationRequest));
    }
    @PostMapping("/singup")
    public void singUp(@RequestBody UserDTO userDTO){
        userService.singup(userDTO);
    }
}
