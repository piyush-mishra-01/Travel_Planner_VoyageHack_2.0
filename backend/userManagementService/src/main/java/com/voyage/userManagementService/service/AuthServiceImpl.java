package com.voyage.userManagementService.service;

import com.voyage.userManagementService.dto.JWTAuthResponse;
import com.voyage.userManagementService.dto.LoginDto;
import com.voyage.userManagementService.dto.RegisterDto;
import com.voyage.userManagementService.entity.Role;
import com.voyage.userManagementService.entity.Traveler;
import com.voyage.userManagementService.entity.User;
import com.voyage.userManagementService.entity.UserProfile;
import com.voyage.userManagementService.enums.Gender;
import com.voyage.userManagementService.exception.TravelPlannerUserServiceException;
import com.voyage.userManagementService.repository.*;
import com.voyage.userManagementService.security.JwtTokenProvider;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

@Service
public class AuthServiceImpl implements AuthService{

    private AuthenticationManager authenticationManager;
    private PasswordEncoder passwordEncoder;
    private JwtTokenProvider jwtTokenProvider;
    private RoleRepository roleRepository;
    private UserRepository userRepository;
    private UserProfileRepository userProfileRepository;
    private TokenRepository tokenRepository;
    private TravelerRepository travelerRepository;

    public AuthServiceImpl(AuthenticationManager authenticationManager, PasswordEncoder passwordEncoder, JwtTokenProvider jwtTokenProvider, RoleRepository roleRepository, UserRepository userRepository, UserProfileRepository userProfileRepository, TokenRepository tokenRepository, TravelerRepository travelerRepository) {
        this.authenticationManager = authenticationManager;
        this.passwordEncoder = passwordEncoder;
        this.jwtTokenProvider = jwtTokenProvider;
        this.roleRepository = roleRepository;
        this.userRepository = userRepository;
        this.userProfileRepository = userProfileRepository;
        this.tokenRepository = tokenRepository;
        this.travelerRepository = travelerRepository;
    }

    @Override
    public JWTAuthResponse login(LoginDto loginDto) {
        return null;
    }

    @Override
    public String register(RegisterDto registerDto, String role) {
            // Check if the username already exists for ROLE_TRAVELER
            if (userRepository.existsUserByUsername(registerDto.getUsername()) && role.equals("ROLE_TRAVELER")) {
                throw new TravelPlannerUserServiceException(
                        "User with the Username : " + registerDto.getUsername() + " already exists");
            }

            // Create and populate User entity
            User user = new User();
            user.setUsername(registerDto.getUsername());
            user.setPassword(passwordEncoder.encode(registerDto.getPassword()));
            user.setMobileNumber(registerDto.getMobileNumber());
            user.setEmail(registerDto.getEmail());

            // Set User roles
            Set<Role> roles = new HashSet<>();
            Role newRole = roleRepository.findByRoleName(role)
                    .orElseThrow(() -> new RuntimeException("Role Not Found"));
            roles.add(newRole);
            user.setRoles(roles);

            // Create and populate UserProfile entity
            UserProfile profile = new UserProfile();
            profile.setFirstname(registerDto.getFirstName());
            profile.setLastname(registerDto.getLastName());
            profile.setGender(registerDto.getGender());

            profile.setPastTrips(new ArrayList<>());
            profile.setSavedTemplates(new ArrayList<>());

            // Link UserProfile with User
            profile.setUser(user);
            user.setUserProfile(profile);

            // Save User (UserProfile is cascaded)
            User savedUser = userRepository.save(user);

            // If role is ROLE_TRAVELER, create and save Traveler entity
            if (role.equals("ROLE_TRAVELER")) {
                Traveler traveler = new Traveler();
                traveler.setId(savedUser.getId());
                traveler.setActive(true);
                traveler.setUser(savedUser);
                travelerRepository.save(traveler);
            }

            return "User Registered Successfully!";
        }

}
