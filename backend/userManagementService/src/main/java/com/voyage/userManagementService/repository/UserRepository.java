package com.voyage.userManagementService.repository;

import com.voyage.userManagementService.entity.User;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;


@Repository
public interface UserRepository extends JpaRepository<User,Long> {
    Optional<User> findUserByUsernameOrEmail(String usernameOrEmail, String usernameOrEmail1);

    Optional<User> findUserByUsername(String username);

    boolean existsUserByUsername(@NotBlank @Pattern(regexp = "^(?=.*[A-Za-z])(?=.*\\d)(?=.*[@$!%*#?&])[A-Za-z0-9@$!%*#?&]{6,}+$",
            message = "Username must contain alphanumeric characters and at least one special character.") String username);
}
