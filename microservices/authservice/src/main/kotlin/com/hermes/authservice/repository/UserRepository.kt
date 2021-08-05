package com.hermes.authservice.repository

import com.hermes.authservice.model.User
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.data.mongodb.repository.Query
import org.springframework.stereotype.Repository

@Repository
interface UserRepository : MongoRepository<User, String>
{
    @Query("{ 'email' : ?0}")
    fun findByEmail(email : String) : User;
}