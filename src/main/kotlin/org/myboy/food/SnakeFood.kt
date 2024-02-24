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
    var x = -1
    var y = -1

    init {
        generateFood()
    }

    fun generateFood() {
        x = random.nextInt(frameWidth / snakeWidth) * snakeWidth
        y = random.nextInt(frameHeight / snakeHeight) * snakeHeight
        println(x)
        println(y)
    }

     fun paintFood(g: Graphics) {
        g.color = Color.green
        g.fillRect(x, y, snakeWidth, snakeHeight)
    }
}
