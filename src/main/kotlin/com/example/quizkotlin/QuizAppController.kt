package com.example.quizkotlin

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import java.io.IOException
import java.util.*

@RestController
class QuizAppController {
    private var quizzes: MutableList<Quiz> = ArrayList()
    private val quizFileDao = QuizFileDao()

    @GetMapping("/quiz")
    fun quiz(): Quiz {
        val index = Random().nextInt(quizzes.size)
        return quizzes[index]
    }

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
            if (quiz.question == question) {
                return if (quiz.answer == answer) {
                    "正解kt"
                } else {
                    "不正解kt"
                }
            }
        }
        return "Not Found"
    }

    @PostMapping
    fun save(): String? {
        return try {
            quizFileDao.write(quizzes)
            "OK!"
        } catch (e: IOException) {
            e.printStackTrace()
            "Failed"
        }
    }

    @GetMapping("/load")
    fun load(): String? {
        return try {
            quizzes = quizFileDao.read() as MutableList<Quiz>
            "Success Read file"
        } catch (e: IOException) {
            e.printStackTrace()
            "Failed"
        }
    }
}
