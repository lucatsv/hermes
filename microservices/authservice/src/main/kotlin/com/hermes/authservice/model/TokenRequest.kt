package com.hermes.authservice.model

class TokenRequest (val username : String, val password : String)  {

    override fun toString(): String {
        return "$username {redacted}"
    }


}