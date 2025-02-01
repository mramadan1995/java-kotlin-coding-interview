package com.cocharge.game.service

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import com.cocharge.game.model.Choice.*
import com.cocharge.game.model.Result.*

class RockPaperScissorsGameTest {

    private val game = RockPaperScissorsGame()

    @Test
    fun `evaluate when Rock vs Scissors should return WIN`() {
        val result = game.evaluate(ROCK, SCISSORS)
        assertEquals(WIN, result)
    }

    @Test
    fun `evaluate when Rock vs Paper should return LOSE`() {
        val result = game.evaluate(ROCK, PAPER)
        assertEquals(LOSE, result)
    }

    @Test
    fun `evaluate when Rock vs Rock should return DRAW`() {
        val result = game.evaluate(ROCK, ROCK)
        assertEquals(DRAW, result)
    }

    @Test
    fun `evaluate when Paper vs Rock should return WIN`() {
        val result = game.evaluate(PAPER, ROCK)
        assertEquals(WIN, result)
    }

    @Test
    fun `evaluate when Paper vs Scissors should return LOSE`() {
        val result = game.evaluate(PAPER, SCISSORS)
        assertEquals(LOSE, result)
    }

    @Test
    fun `evaluate when Paper vs Paper should return DRAW`() {
        val result = game.evaluate(PAPER, PAPER)
        assertEquals(DRAW, result)
    }

    @Test
    fun `evaluate when Scissors vs Paper should return WIN`() {
        val result = game.evaluate(SCISSORS, PAPER)
        assertEquals(WIN, result)
    }

    @Test
    fun `evaluate when Scissors vs Rock should return LOSE`() {
        val result = game.evaluate(SCISSORS, ROCK)
        assertEquals(LOSE, result)
    }

    @Test
    fun `evaluate when Scissors vs Scissors should return DRAW`() {
        val result = game.evaluate(SCISSORS, SCISSORS)
        assertEquals(DRAW, result)
    }
}