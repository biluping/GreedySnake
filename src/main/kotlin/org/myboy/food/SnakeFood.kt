package org.myboy.food

import kotlinx.serialization.Serializable
import org.myboy.frameHeight
import org.myboy.frameWidth
import org.myboy.net.NetUtil
import org.myboy.snakeHeight
import org.myboy.snakeWidth
import java.awt.Color
import java.awt.Graphics
import java.util.*

@Serializable
class SnakeFood(var x : Int = 0, var y : Int = 0) {

    private fun generateCoordinate(frameSize: Int, snakeSize: Int): Int {
        return Random().nextInt(frameSize / snakeSize) * snakeSize
    }

    fun generateFood() {
        x = generateCoordinate(frameWidth, snakeWidth)
        y = generateCoordinate(frameHeight, snakeHeight)
        NetUtil.pushFood(this)
    }

    fun paintFood(g: Graphics) {
        val food = NetUtil.pullFood()
        x = food.x
        y = food.y
        g.color = Color.blue
        g.fillRect(x, y, snakeWidth, snakeHeight)
    }
}