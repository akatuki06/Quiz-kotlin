package com.example.quizkotlin

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import java.util.ArrayList

@RestController
class QuizAppController {

    private val quizzes = ArrayList<String>()
    @GetMapping("/show")
    fun show():List<String> {
        return quizzes
    }

    @PostMapping("/create")
    fun create(@RequestParam question:String, @RequestParam answer:Boolean) {
        val quiz = question + ":" + answer
        quizzes.add(quiz)
    }
}