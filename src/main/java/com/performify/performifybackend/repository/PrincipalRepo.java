package com.performify.performifybackend.repository;

import com.performify.performifybackend.models.Principal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PrincipalRepo extends JpaRepository<Principal,Long> {
}
