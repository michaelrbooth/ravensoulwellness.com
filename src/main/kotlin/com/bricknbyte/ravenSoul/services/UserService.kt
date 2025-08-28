package com.bricknbyte.ravenSoul.services

import com.bricknbyte.ravenSoul.domain.User
import com.bricknbyte.ravenSoul.providers.UserProvider
import com.bricknbyte.ravenSoul.providers.dtos.UserDTO
import org.springframework.stereotype.Service

@Service
class UserService(){//val userRepository: UserProvider) {
    fun saveUser(name: String, email: String): User {
        val user: UserDTO = UserDTO().apply {
            this.id = java.util.UUID.randomUUID().toString()
            this.name = name
            this.email = email

        }
       // userRepository.save(user)
        println("User saved: $user")
        return User(user.id, user.name, user.email)
    }

    fun getAllUsers(): List<User> {
        val users: List<User> = listOf()//userRepository.findAll()
        val returnList = mutableListOf<User>()
        for (user in users) {
            if (user != null) {
                returnList.add(User(user.id, user.name, user.email))
            }
        }
        return returnList.sortedBy { it.name }
    }
}