package com.cocharge.game.model

/**
 * Represents the possible choices in a Rock-Paper-Scissors game.
 */
enum class Choice {
    ROCK, PAPER, SCISSORS , SPOCK, LIZARD;

    companion object {
        /**
         * Returns a random choice from the available values.
         *
         * @return A randomly selected [Choice].
         */

        fun getRandom(): Choice {
            return entries.toTypedArray().random()
        }
    }
}