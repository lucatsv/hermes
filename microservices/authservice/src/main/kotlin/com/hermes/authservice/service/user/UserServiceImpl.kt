package com.hermes.authservice.service.user

import com.hermes.authservice.model.User
import com.hermes.authservice.repository.UserRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class UserServiceImpl (@Autowired val userRepo : UserRepository) : UserService {

    override fun findUser(email: String, password: String): User {

        val user = userRepo.findByEmail(email)

        return if (user != null && user.password == password)
                    user
               else
                   throw Exception("user not found")
    }

    override fun findUser(email: String) : User {
        val user = userRepo.findByEmail(email)
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