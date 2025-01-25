package com.cocharge.game.service

import com.cocharge.game.model.Choice
import com.cocharge.game.model.GameResult
import com.cocharge.game.model.Result

class GameManager(private val game: GameEvaluator) {

    fun playRounds(rounds: Int, playerAChoice: Choice ): GameResult {
        var playerAWins = 0
        var playerBWins = 0
        var draws = 0

        repeat(rounds) {
            val playerBChoice = Choice.getRandom()
            val result = game.evaluate(playerAChoice, playerBChoice)
            when (result) {
                Result.WIN -> playerAWins++
                Result.LOSE -> playerBWins++
                Result.DRAW -> draws++
            }
        }

        return GameResult(playerAWins, playerBWins, draws)
    }
}