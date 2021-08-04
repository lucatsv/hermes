package com.hermes.authservice.controller

import com.hermes.authservice.model.TokenRequest
import com.hermes.authservice.model.TokenResponse
import com.hermes.authservice.model.User
import com.hermes.authservice.model.UserDetailsDecorator
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController
import com.hermes.authservice.service.jwt.JWTService;
import com.hermes.authservice.service.user.UserService

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