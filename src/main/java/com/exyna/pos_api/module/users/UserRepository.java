package com.exyna.pos_api.module.users;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<Users, UUID> {

    List<Users> findAll();

    List<Users> findByUsername(String username);

}
