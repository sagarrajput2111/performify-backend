package com.performify.performifybackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.performify.performifybackend.models.*;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepo extends JpaRepository<User,Long> {
    Optional<User> findByUsername(String username);

}
