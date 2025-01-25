package com.cocharge.game.service

import com.cocharge.game.model.Choice
import com.cocharge.game.model.Result

/**
 * This class represents the Game, which is responsible for executing a single round of the game.
 *
 * @property gameEvaluator An instance of the [GameEvaluator] interface.
 *  It is used to evaluate the choices made by players in a game round.
 *
 * @constructor Creates a Game with a specific evaluation strategy.
 *
 * @param gameEvaluator The strategy for evaluating player choices.
 *
 */
class Game(private val gameEvaluator: GameEvaluator) {

    /**
     * Plays a single round of the game.
     *
     * @param playerAChoice The choice of player A.
     * @param playerBChoice The choice of player B.
     *
     *
     * @return The result of the game round as an instance of [Result].
     *
     */
    fun playRound(playerAChoice: Choice, playerBChoice: Choice): Result {
        return gameEvaluator.evaluate(playerAChoice, playerBChoice)
    }
}