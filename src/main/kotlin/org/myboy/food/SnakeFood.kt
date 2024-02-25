package org.myboy.food

import org.myboy.frameHeight
import org.myboy.frameWidth
import org.myboy.snakeHeight
import org.myboy.snakeWidth
import java.awt.Color
import java.awt.Graphics
import java.util.*

class SnakeFood {

    private val random = Random()
    var x: Int
    var y: Int

    init {
        x = generateCoordinate(frameWidth, snakeWidth)
        y = generateCoordinate(frameHeight, snakeHeight)
    }

    private fun generateCoordinate(frameSize: Int, snakeSize: Int): Int {
        return random.nextInt(frameSize / snakeSize) * snakeSize
    }

    fun generateFood() {
        x = generateCoordinate(frameWidth, snakeWidth)
        y = generateCoordinate(frameHeight, snakeHeight)
    }

    fun paintFood(g: Graphics) {
        g.color = Color.blue
        g.fillRect(x, y, snakeWidth, snakeHeight)
    }
}