package com.bricknbyte.ravensoul

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class RavenSoulApplication

fun main(args: Array<String>) {
    runApplication<RavenSoulApplication>(*args)
}