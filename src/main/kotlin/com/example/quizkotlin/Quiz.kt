package com.example.quizkotlin

class Quiz(val question: String, val answer: Boolean) {
    override fun toString(): String {
        val marubatsu = if (answer) "○" else "×"
        return "$question $marubatsu"
    }

    companion object {
        fun fromStoring(line: String): Quiz {
            val question = line.substring(0, line.length - 2)
            val answer = line.endsWith("○")
            return Quiz(question, answer)
        }
    }
}

