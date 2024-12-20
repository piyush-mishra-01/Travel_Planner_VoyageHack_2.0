package com.voyage.userManagementService.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.Set;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "users")
@Entity
public class User {
    @Getter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Pattern(
            regexp = "^(?=.*[A-Za-z0-9])(?=.*[@$!%*#?&])[A-Za-z0-9@$!%*#?&]+$",
            message = "Username must contain alphanumeric characters and at least one special character."
    )
    @Column(name = "user_name", nullable = false, unique = true)
    private String username;

    @NotBlank
    @Pattern(regexp = "^[0-9]{10}$", message = "Mobile number must be a valid 10-digit number.")
    @Column(nullable = false, unique = true)
    private String mobileNumber;

    @NotBlank
    @Email(message = "Email should be in a proper format.")
    @Column(nullable = false, unique = true)
    private String email;

    @Pattern(
            regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[!@#$%^&*()_+\\-\\[\\]{};':\"\\\\|,.<>\\/?])[A-Za-z\\d!@#$%^&*()_+\\-\\[\\]{};':\"\\\\|,.<>\\/?]{8,}$",
            message = "Password must be at least 8 characters long, contain one uppercase letter, one lowercase letter, one digit, and one special character."
    )
    @Column(nullable = false)
    private String password;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "users_roles", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles;

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private Token token;

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private UserProfile userProfile;
}
