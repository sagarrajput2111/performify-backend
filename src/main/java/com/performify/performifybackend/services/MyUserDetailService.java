package com.performify.performifybackend.services;

import com.performify.performifybackend.models.User;
import com.performify.performifybackend.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailService implements UserDetailsService {
    private UserRepo userRepo;

    public MyUserDetailService(@Autowired UserRepo userRepo)
    {
        this.userRepo=userRepo;

    }
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {



        User user = userRepo.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));

        return new  UserPrincipal(user);

//        return org.springframework.security.core.userdetails.User.builder()
//                .username(user.getUsername())
//                .password(user.getPassword())
//                .roles(user.getRole().name()) // Replace with appropriate roles from userDetails if available
//                .build();
    }
}
