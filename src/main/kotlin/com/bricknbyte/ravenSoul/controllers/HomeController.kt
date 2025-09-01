package com.bricknbyte.ravenSoul.controllers


import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestParam
import com.bricknbyte.ravenSoul.services.UserService
import org.springframework.stereotype.Controller

@Controller
class HomeController(val userService: UserService) {

    @GetMapping("/")
    fun home(model: Model): String {
        model.addAttribute("pageTitle", "Raven Soul Wellness - Home")
        return "index"
    }


    @GetMapping("/booking")
    fun booking(model: Model): String {
        model.addAttribute("pageTitle", "Book Your Session - Raven Soul Wellness")
        return "booking"
    }

    @GetMapping("/about")
    fun about(model: Model): String {
        model.addAttribute("pageTitle", "About Us - Raven Soul Wellness")
        return "about"
    }

    @GetMapping("/health")
    fun health(): String {
        return "health"
    }

    @GetMapping("/users/add")
    fun showSaveForm(): String {
        return "saveUser"
    }

    @PostMapping("/users/save")
    fun saveUser(@RequestParam name: String, @RequestParam email: String, model: Model): String {
        userService.saveUser(name, email)
        val users = userService.getAllUsers()
        model.addAttribute("users", users)
        return "allUsers"
    }

    @GetMapping("/users/all")
    fun getAllUsers(model: Model): String {
        val users = userService.getAllUsers()
        model.addAttribute("users", users)
        return "allUsers"
    }
}
