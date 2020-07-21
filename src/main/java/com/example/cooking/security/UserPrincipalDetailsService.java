package com.example.cooking.security;

import com.example.cooking.model.User;
import com.example.cooking.service.UserService;
import org.springframework.context.annotation.Primary;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@Primary
public class UserPrincipalDetailsService implements UserDetailsService {
    private final UserService userService;

    public UserPrincipalDetailsService(UserService userService) {
        this.userService = userService;
    }

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        User user = userService.getByEmail(userName);
        return new UserPrincipal(user);
    }
}
