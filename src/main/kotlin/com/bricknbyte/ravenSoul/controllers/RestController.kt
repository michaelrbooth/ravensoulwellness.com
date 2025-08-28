package com.bricknbyte.ravenSoul.controllers

import com.bricknbyte.ravenSoul.domain.User
import com.bricknbyte.ravenSoul.services.UserService
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam


@Controller
@RequestMapping("/users")
class RestController(val userService: UserService) {

    @GetMapping("/add")
    fun showSaveForm(): String {
        return "saveUser"
    }

    @PostMapping("/save")
    fun saveUser(@RequestParam name: String, @RequestParam email: String): String {
        userService.saveUser(name, email)
        return "allUsers"
    }

    @GetMapping("/all")
    fun getAllUsers(model: Model): String {
        val users = userService.getAllUsers()
        model.addAttribute("users", users)
        return "allUsers"
    }
}