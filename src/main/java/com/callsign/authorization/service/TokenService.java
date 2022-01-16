package com.callsign.authorization.service;

import com.callsign.authorization.rto.AuthenticationRequest;

/**
 * @author Shadab Khan
 * @since 16/01/2022
 */
public interface TokenService {
    String createAccessToken(AuthenticationRequest authRequest);
}
