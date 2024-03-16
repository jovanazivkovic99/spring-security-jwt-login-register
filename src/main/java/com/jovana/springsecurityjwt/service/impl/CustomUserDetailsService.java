package com.jovana.springsecurityjwt.service.impl;

import com.jovana.springsecurityjwt.exception.user.UserNotFoundException;
import com.jovana.springsecurityjwt.model.User;
import com.jovana.springsecurityjwt.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;

@RequiredArgsConstructor
@Service
public class CustomUserDetailsService implements UserDetailsService {
    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new UserNotFoundException("action.user.login",
                        "error.user.not-found",
                        username,
                        HttpStatus.NOT_FOUND));

        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(),
                Collections.singletonList(new SimpleGrantedAuthority("ROLE_"+user.getRole().name())));
    }
}
