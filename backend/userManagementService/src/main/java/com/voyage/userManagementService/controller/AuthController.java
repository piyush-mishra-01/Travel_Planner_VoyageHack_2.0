package com.voyage.userManagementService.controller;

import com.voyage.userManagementService.dto.JWTAuthResponse;
import com.voyage.userManagementService.dto.LoginDto;
import com.voyage.userManagementService.dto.RegisterDto;
import com.voyage.userManagementService.exception.UserRelatedException;
import com.voyage.userManagementService.service.AuthService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//import org.springframework.security.web.authentication.logout.LogoutHandler;
//import org.springframework.security.core.Authentication;


@RestController
@RequestMapping("/api")
public class AuthController {

    private static final Logger logger = LoggerFactory.getLogger(AuthController.class);

    @Autowired
    private AuthService authService;

    @Operation(summary = "User Login")
    @PostMapping(value = {"/login"})
    public ResponseEntity<JWTAuthResponse> login(@Valid @RequestBody LoginDto loginDto) {
        String role = loginDto.getRole().toUpperCase();
        logger.info("User login with role : {} and username or email : {}",role, loginDto.getUsernameOrEmail());

        if (role.equals("ADMIN") || role.equals("EMPLOYEE") || role.equals("CUSTOMER") || role.equals("AGENT")) {
            JWTAuthResponse jwtAuthResponse = authService.login(loginDto);
            return new ResponseEntity<>(jwtAuthResponse, HttpStatus.OK);
        } else throw new UserRelatedException("Invalid Role!. Login With Proper Role.");
    }


    @Operation(summary = "User Registration")
    @PostMapping(value = {"/register"})
    //@PreAuthorize("permitAll()")
    public ResponseEntity<String> register(@Valid @RequestBody RegisterDto registerDto,
                                            @RequestParam(name = "tempRole") String tempRole) {
        String role = "ROLE_" + tempRole.toUpperCase();

        logger.info("Registering new user for role : {}", role);
        String userDto = authService.register(registerDto, role);

        return ResponseEntity.ok(userDto);
    }

}
