package com.cocharge.game.service

import org.junit.jupiter.api.BeforeEach

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.assertEquals
import org.mockito.Mockito.*
import com.cocharge.game.model.Choice
import com.cocharge.game.model.Result

class GameTest {

    private lateinit var gameEvaluator: GameEvaluator
    private lateinit var game: Game

    @BeforeEach
    fun setup() {
        gameEvaluator = mock(GameEvaluator::class.java)
        game = Game(gameEvaluator)
    }

    @Test
    fun `playRound should verify call of evaluate function`() {
        // Arrange
        val playerAChoice = Choice.ROCK
        val playerBChoice = Choice.SCISSORS
        val expectedResult = Result.WIN

        // Mock
        `when`(gameEvaluator.evaluate(playerAChoice, playerBChoice)).thenReturn(expectedResult)

        // Act
        val result = game.playRound(playerAChoice, playerBChoice)

        // verify
        assertEquals(expectedResult, result)
        verify(gameEvaluator).evaluate(playerAChoice, playerBChoice)
    }

}