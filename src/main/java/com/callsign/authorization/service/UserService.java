package com.callsign.authorization.service;

import com.callsign.authorization.model.User;

/**
 * @author Shadab Khan
 * @since 09/01/2022
 */
public interface UserService {
    User loadUserByUsername(String username);
}
