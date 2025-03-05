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
        assertEquals(DRAW, game.evaluate(SPOCK, SPOCK))
        assertEquals(DRAW, game.evaluate(LIZARD, LIZARD))
    }

    @Test
    fun `test WIN cases`() {
        assertEquals(WIN, game.evaluate(ROCK, SCISSORS))
        assertEquals(WIN, game.evaluate(ROCK, LIZARD))
        assertEquals(WIN, game.evaluate(PAPER, ROCK))
        assertEquals(WIN, game.evaluate(PAPER, SPOCK))
        assertEquals(WIN, game.evaluate(SCISSORS, PAPER))
        assertEquals(WIN, game.evaluate(SCISSORS, LIZARD))
        assertEquals(WIN, game.evaluate(SPOCK, ROCK))
        assertEquals(WIN, game.evaluate(SPOCK, SCISSORS))
        assertEquals(WIN, game.evaluate(LIZARD, PAPER))
        assertEquals(WIN, game.evaluate(LIZARD, SPOCK))
    }

    @Test
    fun `test LOSE cases`() {
        assertEquals(LOSE, game.evaluate(ROCK, PAPER))
        assertEquals(LOSE, game.evaluate(ROCK, SPOCK))
        assertEquals(LOSE, game.evaluate(PAPER, SCISSORS))
        assertEquals(LOSE, game.evaluate(PAPER, LIZARD))
        assertEquals(LOSE, game.evaluate(SCISSORS, ROCK))
        assertEquals(LOSE, game.evaluate(SCISSORS, SPOCK))
        assertEquals(LOSE, game.evaluate(SPOCK, LIZARD))
        assertEquals(LOSE, game.evaluate(SPOCK, PAPER))
        assertEquals(LOSE, game.evaluate(LIZARD, ROCK))
        assertEquals(LOSE, game.evaluate(LIZARD, SCISSORS))
    }
}