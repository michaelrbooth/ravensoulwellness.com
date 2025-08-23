package com.bricknbyte.ravenSoul.controllers

import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping

@Controller
class HomeController {

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
}
