package com.exyna.pos_api.users;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.exyna.pos_api.users.internal.Users;

public interface UserRepository extends JpaRepository<Users, UUID> {

    List<Users> findAll();

    List<Users> findByUsername(String username);

}
