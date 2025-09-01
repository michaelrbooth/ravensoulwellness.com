package com.bricknbyte.ravenSoul.providers.dtos

import com.google.cloud.spring.data.datastore.core.mapping.Entity
import org.springframework.data.annotation.Id

@Entity(name = "user")
data class UserDTO (
    @Id
    var id: String,
    val username: String,
    val email: String


)