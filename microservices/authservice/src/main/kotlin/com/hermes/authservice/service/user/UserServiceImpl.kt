package com.hermes.authservice.service.user

import com.hermes.authservice.model.User
import org.springframework.stereotype.Service

@Service
class UserServiceImpl : UserService {

    private val usersDB = listOf(User())

    override fun findUser(username: String, password: String): User {

        val user = usersDB.first{ it.username == username && it.password == password}

        return if(user == null) {
            throw Exception("user not found")
        } else {
            user
        }
    }

    override fun findUser(username: String) : User {
        val user = usersDB.first{ it.username == username }
        return if(user == null) {
            throw Exception("user not found")
        } else {
            user
        }

    }

    override fun createUser(user: User): User {
        TODO("Not yet implemented")
    }

    override fun deleteUser(userId: String) {
        TODO("Not yet implemented")
    }
}