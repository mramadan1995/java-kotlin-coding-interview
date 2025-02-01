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
    fun `playRounds when player B and player A win together should return GameResult of all values`() {
        `when`(gameEvaluator.evaluate(any(), any()))
            .thenReturn(Result.WIN)
            .thenReturn(Result.LOSE)
            .thenReturn(Result.DRAW)
            .thenReturn(Result.WIN)
            .thenReturn(Result.LOSE)

        val result = gameManager.playRounds(5, Choice.ROCK)

        assertEquals(2, result.playerAWins)
        assertEquals(2, result.playerBWins)
        assertEquals(1, result.draws)
    }

    @Test
    fun `playRounds when Player A wins all rounds should return GameResult of only playerAWins`() {
        `when`(gameEvaluator.evaluate(any(), any())).thenReturn(Result.WIN)

        val result = gameManager.playRounds(5, Choice.ROCK)

        assertEquals(5, result.playerAWins)
        assertEquals(0, result.playerBWins)
        assertEquals(0, result.draws)
    }

    @Test
    fun `playRounds when player B wins all rounds should return GameResult of only playerBWins`() {
        `when`(gameEvaluator.evaluate(any(), any())).thenReturn(Result.LOSE)

        val result = gameManager.playRounds(4, Choice.ROCK)

        assertEquals(0, result.playerAWins)
        assertEquals(4, result.playerBWins)
        assertEquals(0, result.draws)
    }

    @Test
    fun `playRounds when player B and player A draws all rounds should return GameResult of only draws`() {
        `when`(gameEvaluator.evaluate(any(), any())).thenReturn(Result.DRAW)

        val result = gameManager.playRounds(2, Choice.ROCK)

        assertEquals(0, result.playerAWins)
        assertEquals(0, result.playerBWins)
        assertEquals(2, result.draws)
    }

    @Test
    fun `playRounds when zero rounds should return all zeroes`() {
        val result = gameManager.playRounds(0, Choice.ROCK)

        assertEquals(0, result.playerAWins)
        assertEquals(0, result.playerBWins)
        assertEquals(0, result.draws)
    }
}