package com.bricknbyte.ravenSoul.controllers

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping

@Controller
class HomeController {

    @GetMapping("/")
    fun home(): String {
        return "index"
    }

    @GetMapping("/health")
    fun health(): String {
        return "health"
    }
}
