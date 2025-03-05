package com.cocharge.game.service

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.BeforeEach
import org.mockito.Mockito.`when`
import org.mockito.Mockito.mock
import org.mockito.kotlin.any
import com.cocharge.game.model.Result
import com.cocharge.game.model.Choice

class GameManagerTest {

    private lateinit var gameEvaluator: GameEvaluator
    private lateinit var gameManager: GameManager

    @BeforeEach
    fun setUp() {
        gameEvaluator = mock(GameEvaluator::class.java)
        gameManager = GameManager(gameEvaluator)
    }

    @Test
    fun `test playRounds counts results correctly`() {
        `when`(gameEvaluator.evaluate(any(), any())).thenReturn(Result.WIN)
        val result = gameManager.playRounds(100, Choice.ROCK)
        assertEquals(100, result.playerAWins)
        assertEquals(0, result.playerBWins)
        assertEquals(0, result.draws)
    }

    @Test
    fun `test playRounds when all rounds are draws`() {
        `when`(gameEvaluator.evaluate(any(), any())).thenReturn(Result.DRAW)
        val result = gameManager.playRounds(50, Choice.PAPER)
        assertEquals(0, result.playerAWins)
        assertEquals(0, result.playerBWins)
        assertEquals(50, result.draws)
    }

    @Test
    fun `test playRounds when all rounds are losses`() {
        `when`(gameEvaluator.evaluate(any(),any())).thenReturn(Result.LOSE)
        val result = gameManager.playRounds(30, Choice.SCISSORS)
        assertEquals(0, result.playerAWins)
        assertEquals(30, result.playerBWins)
        assertEquals(0, result.draws)
    }

    @Test
    fun `test playRounds with randoms results`() {
        `when`(gameEvaluator.evaluate(any(), any()))
            .thenReturn(Result.WIN, Result.LOSE, Result.DRAW, Result.WIN, Result.LOSE)

        val result = gameManager.playRounds(5, Choice.ROCK)
        assertEquals(2, result.playerAWins)
        assertEquals(2, result.playerBWins)
        assertEquals(1, result.draws)
    }
    @Test
    fun `playRounds when zero rounds should return all zeroes`() {
        val result = gameManager.playRounds(0, Choice.ROCK)
        assertEquals(0, result.playerAWins)
        assertEquals(0, result.playerBWins)
        assertEquals(0, result.draws)
    }
}