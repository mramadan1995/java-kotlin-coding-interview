package com.cocharge.game.model

class Player(val strategy: () -> Move) {
    fun play(): Move = strategy()
}