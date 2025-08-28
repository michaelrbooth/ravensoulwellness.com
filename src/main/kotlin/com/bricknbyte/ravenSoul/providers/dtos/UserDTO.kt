package com.bricknbyte.ravenSoul.providers.dtos

//import com.google.cloud.spring.data.datastore.core.mapping.Entity
//import org.springframework.data.annotation.Id;

//Entity(name = "User")
class UserDTO {
    //Id
    var id: String = java.util.UUID.randomUUID().toString()
    var name: String = ""
    var email: String = ""


}