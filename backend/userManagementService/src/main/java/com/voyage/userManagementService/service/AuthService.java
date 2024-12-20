package com.voyage.userManagementService.service;

import com.voyage.userManagementService.dto.JWTAuthResponse;
import com.voyage.userManagementService.dto.LoginDto;
import com.voyage.userManagementService.dto.RegisterDto;
import jakarta.validation.Valid;

public interface AuthService {
    JWTAuthResponse login(@Valid LoginDto loginDto);

    String register(RegisterDto registerDto, String role);
}
