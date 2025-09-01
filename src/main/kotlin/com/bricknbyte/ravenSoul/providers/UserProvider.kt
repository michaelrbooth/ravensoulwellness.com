package com.bricknbyte.ravenSoul.providers

import com.bricknbyte.ravenSoul.providers.dtos.UserDTO
import com.google.cloud.spring.data.datastore.repository.DatastoreRepository
import org.springframework.stereotype.Repository

@Repository
interface UserProvider : DatastoreRepository<UserDTO, String> {

    fun findByUsername(username: String): UserDTO?
}