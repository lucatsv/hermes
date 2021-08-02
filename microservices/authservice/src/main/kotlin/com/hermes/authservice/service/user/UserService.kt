package com.hermes.authservice.service.user

import com.hermes.authservice.model.User

interface UserService {

    fun findUser(username : String, password : String) : User

    fun findUser(username: String) : User

    fun createUser(user : User) : User

    fun deleteUser(userId : String)

}