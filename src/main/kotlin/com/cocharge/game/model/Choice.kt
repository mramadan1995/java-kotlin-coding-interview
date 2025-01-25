package com.cocharge.game.model

enum class Choice {
    ROCK, PAPER, SCISSORS;

    companion object {
        fun getRandom(): Choice {
            return entries.toTypedArray().random()
        }
    }
}