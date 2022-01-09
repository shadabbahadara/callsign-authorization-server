package com.callsign.authorization.repository;

import com.callsign.authorization.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


/**
 * @author Shadab Khan
 * @since 08/01/2022
 */
public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(String name);
}
