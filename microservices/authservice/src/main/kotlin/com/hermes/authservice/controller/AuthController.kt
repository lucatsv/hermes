package com.hermes.authservice.controller

import com.hermes.authservice.model.TokenRequest
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class AuthController {

    @GetMapping(path = ["hello"])
    fun helloWorld() : String {
        return "hello world"
    }

    @PostMapping(path = ["token"])
    fun getToken(@RequestBody tokenRequest: TokenRequest) : String {
        return tokenRequest.toString()
    }


}