package com.example.quizkotlin

import org.hamcrest.CoreMatchers
import org.junit.Assert
import org.junit.Test

class QuizTest {
    @Test
    fun toStringWhenMaru() {
        val quiz = Quiz("問題文", true)
        Assert.assertThat(quiz.toString(), CoreMatchers.`is`("問題文 ○"))
    }

    @Test
    fun toStringWhenBatsu() {
        val quiz = Quiz("問題文", false)
        Assert.assertThat(quiz.toString(), CoreMatchers.`is`("問題文 ×"))
    }

    @Test
    fun fromStringWhenMaru() {
        val line = "問題文1 ○"
        val quiz = Quiz.fromStoring(line)
        Assert.assertThat(quiz.question, CoreMatchers.`is`("問題文1"))
        Assert.assertThat(quiz.answer, CoreMatchers.`is`(true))
    }

    @Test
    fun fromStringWhenBatsu() {
        val line = "問題文1 ×"
        val quiz = Quiz.fromStoring(line)
        Assert.assertThat(quiz.question, CoreMatchers.`is`("問題文1"))
        Assert.assertThat(quiz.answer, CoreMatchers.`is`(false))
    }
}