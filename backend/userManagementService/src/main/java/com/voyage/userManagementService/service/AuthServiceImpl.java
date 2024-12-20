package com.voyage.userManagementService.service;

import com.voyage.userManagementService.dto.JWTAuthResponse;
import com.voyage.userManagementService.dto.LoginDto;
import com.voyage.userManagementService.dto.RegisterDto;
import com.voyage.userManagementService.entity.*;
import com.voyage.userManagementService.enums.TokenType;
import com.voyage.userManagementService.exception.TravelPlannerUserServiceException;
import com.voyage.userManagementService.repository.*;
import com.voyage.userManagementService.security.JwtTokenProvider;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Optional;
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
        User user = userRepository
                .findUserByUsernameOrEmail(loginDto.getUsernameOrEmail(), loginDto.getUsernameOrEmail())
                .orElseThrow(() -> new TravelPlannerUserServiceException(
                        "User with username or email " + loginDto.getUsernameOrEmail() + " cannot be found"));



        Authentication authentication = authenticationManager
                .authenticate(new UsernamePasswordAuthenticationToken(user.getUsername(), loginDto.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);

        String token = jwtTokenProvider.generateToken(authentication);
        saveToken(user, token);
        JWTAuthResponse jwtAuthResponse = new JWTAuthResponse();
        jwtAuthResponse.setAccessToken(token);

        for (Role newRole : user.getRoles()) {
            jwtAuthResponse.setRole(newRole.getRoleName());
            break;
        }

        return jwtAuthResponse;
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

    private Token saveToken(User user, String jwtToken) {
        Token token = new Token();
        if (user.getToken() != null) {
            token.setId(user.getToken().getId());
        }
        token.setToken(jwtToken);
        token.setUser(user);
        token.setRevoked(false);
        token.setExpired(false);
        token.setTokenType(TokenType.BEARER);
        tokenRepository.save(token);

        return token;

    }

    //@Override
    public Boolean validateUserToken(HttpServletRequest request, String forrole) {
        final String authHeader = request.getHeader("Authorization");
        final String token = authHeader.substring(7);
        Token tokenObject = tokenRepository.findByToken(token).get();
        if (tokenObject == null || tokenObject.getExpired() || tokenObject.getRevoked())
            return false;

        String username = jwtTokenProvider.getUsername(token);
        Optional<User> byUsername = userRepository.findUserByUsernameOrEmail(username, username);
        if (byUsername.isEmpty())
            return false;
        Set<Role> roles = byUsername.get().getRoles();
        for (Role role : roles) {
            //System.out.println(role.getRoleName() + "==========================================================ROLENAME" + forrole);
            if (role.getRoleName().equalsIgnoreCase(forrole))
                return true;
        }

        return false;
    }

//    @Override
//    public UserDto getLoggedUser(HttpServletRequest request) {
//        final String authHeader = request.getHeader("Authorization");
//        final String token = authHeader.substring(7);
//
//        Token tokenObject = tokenRepository.findByToken(token)
//                .orElseThrow(() -> new FortuneLifeException("Token cannot be found"));
//
//        if (tokenObject.getExpired() || tokenObject.getRevoked()) {
//            throw new FortuneLifeException("Invalid Token");
//        }
//
//        String username = jwtTokenProvider.getUsername(token);
//        User user = userRepository.findUserByUsernameOrEmail(username, username)
//                .orElseThrow(() -> new UserRelatedException("User with username or email : " + username + " cannot be found"));
//
//        return userMapper.entityToDto(user);
//    }


}
