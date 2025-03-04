package com.voyage.userManagementService.dto;

import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class LoginDto {
    @Pattern(regexp = "^(?=.{3,50}$)([A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,6}|(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]+)$",
            message = "Username must contain at least one special character and one number, or be a valid email address.")
    private String usernameOrEmail;

    @Pattern(
            regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[!@#$%^&*()_+\\-\\[\\]{};':\"\\\\|,.<>\\/?])[A-Za-z\\d!@#$%^&*()_+\\-\\[\\]{};':\"\\\\|,.<>\\/?]{8,}$",
            message = "Password must be at least 8 characters long, contain one uppercase letter, one lowercase letter, one digit, and one special character."
    )
    private String password;

    private String role;
}
