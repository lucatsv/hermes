package com.hermes.authservice.model

import com.fasterxml.jackson.annotation.JsonIgnore
import jdk.jfr.Enabled
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.userdetails.UserDetails

@Document
class User (
    @Id val id : String,
    val firstName : String,
    val lastName : String,
    var email : String,
    @JsonIgnore var password : String,
    val role : String,
    val expired : Boolean,
    val locked : Boolean,
    val credentialExpired : Boolean,
    val enabled: Boolean
) {





}