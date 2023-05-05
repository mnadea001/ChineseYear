package com.example.chineseyear.security.services;

import org.springframework.security.core.userdetails.UserDetails;

public class UserDetailsService {
    UserDetails loadUserByUsername(String username) throws UsernameNotFoundException;
}
