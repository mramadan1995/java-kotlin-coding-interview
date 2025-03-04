package com.cocharge.game.service

import com.cocharge.game.model.Choice
import com.cocharge.game.model.Choice.*
import com.cocharge.game.model.Result
import com.cocharge.game.model.Result.*

/**
 * This class provides an implementation of the [GameEvaluator] for the Rock-Paper-Scissors game.
 *
 * It determines the outcome of a game round based on the classic rules:
 * - Rock crushes Scissors
 * - Scissors cut Paper
 * - Paper covers Rock
 *
 * @see GameEvaluator
 * @see Choice
 * @see Result
 */

class RockPaperScissorsGame : GameEvaluator {

    private val winningConditions: Map<Choice, Choice> = mapOf(
        ROCK to SCISSORS,
        PAPER to ROCK,
        SCISSORS to PAPER
    )

    /**
     * Evaluates the choices of two players in a round of Rock-Paper-Scissors game.
     *
     * @param playerAChoice The choice (Rock, Paper or Scissors) of Player A.
     * @param playerBChoice The choice (Rock, Paper or Scissors) of Player B.
     *
     * @return [Result] of the game round based on the choices of both players.
     * The possible results are WIN, LOSE, or DRAW.
     *
     * @see Choice
     * @see Result
     */
    override fun evaluate(playerAChoice: Choice, playerBChoice: Choice): Result {
        return when {
            playerAChoice == playerBChoice -> DRAW
            playerBChoice == winningConditions[playerAChoice]!! -> WIN
            else -> LOSE
        }

    }


}