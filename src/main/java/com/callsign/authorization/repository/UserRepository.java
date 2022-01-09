package com.callsign.authorization.repository;

import com.callsign.authorization.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * @author Shadab Khan
 * @since 08/01/2022
 */
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);
}
