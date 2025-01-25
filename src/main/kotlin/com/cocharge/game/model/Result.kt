package com.cocharge.game.model

/**
 * Represents the possible outcomes of a game round.
 *
 * @see WIN means The player wins the round
 * @see LOSE means The player loses the round
 * @see DRAW means The round ends in a draw
 */
enum class Result {
    WIN,
    LOSE,
    DRAW
}