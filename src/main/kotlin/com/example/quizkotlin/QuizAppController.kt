package com.example.quizkotlin

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
@RestController
class QuizAppController {
    @GetMapping("/show")
    fun show():String {
        return "Kotlin!!"
    }
}