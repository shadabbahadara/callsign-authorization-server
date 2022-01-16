package com.callsign.authorization.service;

import com.callsign.authorization.exception.IncorrectPasswordException;
import com.callsign.authorization.model.User;
import com.callsign.authorization.rto.AuthenticationRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @author Shadab Khan
 * @since 16/01/2022
 */
@Service
@RequiredArgsConstructor
@Slf4j
public class TokenServiceImpl implements TokenService {
    private final UserService userService;
    private final JwtService jwtUtil;

    @Override
    public String createAccessToken(AuthenticationRequest authRequest) {
        final User user = userService.loadUserByUsername(authRequest.getUsername());
        if (!user.getPassword().equals(authRequest.getPassword())) {
            log.error("incorrect password for user {}", user.getUsername());
            throw new IncorrectPasswordException("incorrect password");
        }
        final String jwt = jwtUtil.generateToken(user);
        return jwt;
    }
}
