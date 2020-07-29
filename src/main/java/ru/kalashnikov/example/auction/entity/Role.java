package ru.kalashnikov.example.auction.entity;

import org.springframework.security.core.GrantedAuthority;

public enum  Role implements GrantedAuthority {
    GUEST,
    ;

    @Override
    public String getAuthority() {
        return name();
    }
}
