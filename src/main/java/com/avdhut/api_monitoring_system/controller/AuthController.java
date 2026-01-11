package com.avdhut.api_monitoring_system.controller;

import com.avdhut.api_monitoring_system.dto.LoginRequest;
import com.avdhut.api_monitoring_system.dto.LoginResponse;
import com.avdhut.api_monitoring_system.entity.User;
import com.avdhut.api_monitoring_system.repository.UserRepository;
import com.avdhut.api_monitoring_system.security.JwtUtil;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final AuthenticationManager authenticationManager;
    private final JwtUtil jwtUtil;

    public AuthController(AuthenticationManager authenticationManager,
                          JwtUtil jwtUtil) {
        this.authenticationManager = authenticationManager;
        this.jwtUtil = jwtUtil;
    }

    @PostMapping("/login")
    public LoginResponse login(@RequestBody LoginRequest request) {

        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.email(),
                        request.password()
                )
        );

        String token = jwtUtil.generateToken(request.email());
        return new LoginResponse(token);
    }
}
