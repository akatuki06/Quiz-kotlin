package com.example.quizkotlin

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import java.util.*

@RestController
class QuizAppController {
    private val quizzes: MutableList<Quiz> = ArrayList()
    @GetMapping("/show")
    fun show(): List<Quiz> {
        return quizzes
    }

    @PostMapping("/create")
    fun create(@RequestParam question: String, @RequestParam answer: Boolean) {
        val quiz = Quiz(question, answer)
        quizzes.add(quiz)
    }

    @GetMapping("/check")
    fun check(question: String, answer: Boolean): String {
        for (quiz in quizzes) {
            if (quiz.question.equals(question)) {
                return "Found : " + quiz.question
            }
        }
        return "Not Found"
    }
}
