package io.ankit.security.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import io.ankit.security.entity.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Integer> {

}
