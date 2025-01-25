package com.cocharge.game.service

import com.cocharge.game.model.Choice
import com.cocharge.game.model.Result

/**
 * A Game evaluator for evaluating the choices of two players.
 *
 * @see Choice
 * @see Result
 */
interface GameEvaluator {

    /**
     * Evaluates the choices of two players against each other.
     *
     * @param playerAChoice The choice of player A.
     * @param playerBChoice The choice of player B.
     *
     * @return The result of the evaluation as an instance of [Result].
     *
     *  @see Choice
     *  @see Result
     */
    fun evaluate(playerAChoice: Choice, playerBChoice: Choice): Result

}