package com.hermes.authservice.controller

import com.hermes.authservice.model.TokenRequest
import com.hermes.authservice.model.TokenResponse
import com.hermes.authservice.model.UserDetailsDecorator
import com.hermes.authservice.service.jwt.JWTService;
import com.hermes.authservice.service.user.UserService
import org.springframework.web.bind.annotation.*

@RestController
class AuthController(val jwtService: JWTService, val userService : UserService) {

    @PostMapping(path = ["token"])
    fun getToken(@RequestBody tokenRequest: TokenRequest) : TokenResponse {

        val user = userService.findUser(tokenRequest.username, tokenRequest.password)

        return TokenResponse(jwtService.generateToken(UserDetailsDecorator(user)))
    }

    @PostMapping(path = ["validate-token"])
    fun validateToken(@RequestBody tokenResponse: TokenResponse) : Boolean {

        val username = jwtService.getUsernameFromToken(tokenResponse.token)

        val user = userService.findUser(username)

        return jwtService.validateToken(tokenResponse.token, UserDetailsDecorator(user))
    }
    
}