package com.example.quizkotlin

class Quiz(val question: String, val answer: Boolean) {
    override fun toString(): String {
        val marubatsu = if (answer) "○" else "×"
        return "$question $marubatsu"
    }
}