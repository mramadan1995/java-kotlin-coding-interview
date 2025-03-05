package com.cocharge.game.service

import com.cocharge.game.model.Choice.*
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import com.cocharge.game.model.Result.*

class RockPaperScissorsGameTest {

    private val game = RockPaperScissorsGame()

    @Test
    fun `test DRAW cases`() {
        assertEquals(DRAW, game.evaluate(ROCK, ROCK))
        assertEquals(DRAW, game.evaluate(PAPER, PAPER))
        assertEquals(DRAW, game.evaluate(SCISSORS, SCISSORS))
    }

    @Test
    fun `test WIN cases`() {
        assertEquals(WIN, game.evaluate(ROCK, SCISSORS))
        assertEquals(WIN, game.evaluate(PAPER, ROCK))
        assertEquals(WIN, game.evaluate(SCISSORS, PAPER))
    }

    @Test
    fun `test LOSE cases`() {
        assertEquals(LOSE, game.evaluate(ROCK, PAPER))
        assertEquals(LOSE, game.evaluate(PAPER, SCISSORS))
        assertEquals(LOSE, game.evaluate(SCISSORS, ROCK))
    }
}