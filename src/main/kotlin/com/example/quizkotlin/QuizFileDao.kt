package com.example.quizkotlin

import java.io.IOException
import java.nio.file.Files
import java.nio.file.Paths
import java.util.*


class QuizFileDao {
    @Throws(IOException::class)
    fun write(quizzes: List<Quiz>) {
        val lines: MutableList<String> = ArrayList()
        for (quiz in quizzes) {
            lines.add(quiz.toString())
        }
        val path = Paths.get(FILE_PATH)
        Files.write(path, lines)
    }

    companion object {
        private const val FILE_PATH = "quizzes.txt"
    }
}