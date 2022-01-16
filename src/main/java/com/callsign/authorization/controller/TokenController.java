package com.callsign.authorization.controller;

import com.callsign.authorization.rto.AuthenticationRequest;
import com.callsign.authorization.rto.AuthenticationResponse;
import com.callsign.authorization.service.TokenService;
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
public class TokenController {
    private final TokenService tokenService;

    @PostMapping("/token")
    public ResponseEntity<AuthenticationResponse> createAuthToken(@RequestBody AuthenticationRequest authRequest) {
        final String jwt = tokenService.createAccessToken(authRequest);
        return ResponseEntity.ok(new AuthenticationResponse(jwt));
    }
}
