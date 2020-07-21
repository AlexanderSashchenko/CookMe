package com.example.cooking.security;

import com.example.cooking.model.User;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class UserPrincipal implements UserDetails {
    private final User user;

    public UserPrincipal(User user) {
        this.user = user;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> authorities = new ArrayList<>();

        this.user.getRoles().forEach(role -> {
            GrantedAuthority authority = new SimpleGrantedAuthority("ROLE_" + role.getRoleName());
            authorities.add(authority);
        });

        return authorities;
    }

    @Override
    public String getPassword() {
        return this.user.getPassword();
    }

    @Override
    public String getUsername() {
        return this.user.getEmail();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true; //TODO: resolve hardcode
    }

    @Override
    public boolean isAccountNonLocked() {
        return true; //TODO: resolve hardcode
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true; //TODO: resolve hardcode
    }

    @Override
    public boolean isEnabled() {
        return true; //TODO: resolve hardcode
    }
}
