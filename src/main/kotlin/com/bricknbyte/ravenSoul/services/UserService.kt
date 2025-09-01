package com.bricknbyte.ravenSoul.services

import com.bricknbyte.ravenSoul.domain.User
import com.bricknbyte.ravenSoul.providers.UserProvider
import com.bricknbyte.ravenSoul.providers.dtos.UserDTO
import org.springframework.stereotype.Service

@Service
class UserService(val userRepository: UserProvider) {
    fun saveUser(name: String, email: String): User {
        val user = UserDTO(
            id = java.util.UUID.randomUUID().toString(),
            username = name,
            email = email
        )
        userRepository.save(user)
        println("User saved: $user")
        return User(user.id, user.username, user.email)
    }

    fun getAllUsers(): List<User> {
        val users = userRepository.findAll()
        val returnList = mutableListOf<User>()
        for (user in users) {
            returnList.add(User(user.id, user.username, user.email))
        }
        return returnList.sortedBy { it.name }
    }
}