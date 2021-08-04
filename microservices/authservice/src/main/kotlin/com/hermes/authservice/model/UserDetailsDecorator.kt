package com.hermes.authservice.model

import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.userdetails.UserDetails

class UserDetailsDecorator (private val user : User) : UserDetails {

    override fun getAuthorities(): MutableCollection<out GrantedAuthority> {
        return mutableListOf()
    }

    override fun getPassword(): String {
        return user.password
    }

    override fun getUsername(): String {
        return user.email
    }

    override fun isAccountNonExpired(): Boolean {
        return user.expired
    }

    override fun isAccountNonLocked(): Boolean {
        return user.locked
    }

    override fun isCredentialsNonExpired(): Boolean {
        return user.credentialExpired
    }

    override fun isEnabled(): Boolean {
        return user.enabled
    }
}