package com.cocharge.game.model

/**
 * Represents the results of a game between two players.
 *
 * @property playerAWins The number of games won by Player A.
 * @property playerBWins The number of games won by Player B.
 * @property draws The number of games that ended in a draw.
 */
data class GameResult(val playerAWins: Int, val playerBWins: Int, val draws: Int)
