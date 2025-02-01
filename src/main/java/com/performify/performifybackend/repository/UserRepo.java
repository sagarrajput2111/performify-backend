package com.performify.performifybackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.performify.performifybackend.models.*;

import java.util.Optional;

public interface UserRepo extends JpaRepository<User,Long> {
    Optional<User> findByUsername(String username);

}
