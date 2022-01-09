package com.callsign.authorization.controller;

import com.callsign.authorization.exception.IncorrectPasswordException;
import com.callsign.authorization.model.User;
import com.callsign.authorization.rto.AuthenticationRequest;
import com.callsign.authorization.rto.AuthenticationResponse;
import com.callsign.authorization.service.UserService;
import com.callsign.authorization.util.JwtUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Shadab Khan
 * @since 08/01/2022
 */
@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
@Slf4j
public class LoginController {

    private final UserService userService;
    private final JwtUtil jwtUtil;

    @PostMapping("/token")
    public ResponseEntity<AuthenticationResponse> createAuthToken(@RequestBody AuthenticationRequest authRequest) {
        final User user = userService.loadUserByUsername(authRequest.getUsername());
        if (!user.getPassword().equals(authRequest.getPassword())) {
            throw new IncorrectPasswordException("incorrect password");
        }
        final String jwt = jwtUtil.generateToken(user);
        return ResponseEntity.ok(new AuthenticationResponse(jwt));
    }
}
