package com.callsign.authorization.controller;

import com.callsign.authorization.model.User;
import com.callsign.authorization.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Shadab Khan
 * @since 08/01/2022
 */
@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
@Slf4j
public class UserController {
    private final UserService userService;

    @GetMapping("/{username}")
    public ResponseEntity<User> findUserByUsername(@PathVariable String username) {
        log.info("fetching user details for user {}", username);
        final User user = userService.loadUserByUsername(username);
        return ResponseEntity.ok(user);
    }
}
