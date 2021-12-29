package com.hoaxifyapp.hoaxifyapp.api;

import com.hoaxifyapp.hoaxifyapp.business.abstracts.UserService;
import com.hoaxifyapp.hoaxifyapp.business.utilities.annotations.CurrentUser;
import com.hoaxifyapp.hoaxifyapp.core.business.auth.TokenManager;
import com.hoaxifyapp.hoaxifyapp.core.utilities.results.DataResult;
import com.hoaxifyapp.hoaxifyapp.core.utilities.results.SuccessDataResult;
import com.hoaxifyapp.hoaxifyapp.entities.concreates.User;
import com.hoaxifyapp.hoaxifyapp.entities.concreates.dtos.LoginDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final AuthenticationManager authenticationManager;

    private final TokenManager tokenManager;

    private final UserService userService;

    @Autowired
    public AuthController(AuthenticationManager authenticationManager, TokenManager tokenManager,UserService userService) {
        this.authenticationManager = authenticationManager;
        this.tokenManager = tokenManager;
        this.userService=userService;
    }

    @PostMapping("/login")
    public DataResult<String> login(@RequestBody LoginDto loginDto) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginDto.getUsername(), loginDto.getPassword()));
        return new SuccessDataResult<>(tokenManager.createToken(loginDto.getUsername()),"Giriş yapıldı");

    }

    @PostMapping("/register")
    public DataResult<String> register(@RequestBody User user) {
        userService.add(user);
        return new SuccessDataResult<>("Katıy yapıldı");

    }




}
