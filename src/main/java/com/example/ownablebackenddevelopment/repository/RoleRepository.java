package com.example.ownablebackenddevelopment.repository;

import com.example.ownablebackenddevelopment.domain.UserRole;
import com.example.ownablebackenddevelopment.domain.enumeration.UserRoles;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<UserRole, Long> {
    Optional<UserRole> findByName(UserRoles userRoles);
}
