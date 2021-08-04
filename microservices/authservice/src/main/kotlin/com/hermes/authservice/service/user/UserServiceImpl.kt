package com.hermes.authservice.service.user

import com.hermes.authservice.model.User
import com.hermes.authservice.repository.UserRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class UserServiceImpl (@Autowired val userRepo : UserRepository) : UserService {

    override fun findUser(username: String, password: String): User {


        val allUsers = userRepo.findAll();

        return allUsers.first { it.email == username && it.password == password } ?: throw Exception("user not found")
    }

    override fun findUser(username: String) : User {
        val user = userRepo.findAll().first{ it.email == username }
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