package org.myboy.snake

import org.myboy.enums.DirectEnum
import org.myboy.food.SnakeFood
import org.myboy.frameHeight
import org.myboy.frameWidth
import org.myboy.snakeHeight
import org.myboy.snakeWidth
import java.awt.Color
import java.awt.Graphics
import java.util.*

class Snake {
    var direct = DirectEnum.randomDirect()
    private val random = Random()
    private val bodyList = arrayListOf<SnakeBody>()

    init {
        generateSnake()
    }

    fun generateSnake() {
        direct = DirectEnum.randomDirect()
        val headX = random.nextInt(3, frameWidth / snakeWidth) * snakeWidth
        val headY = random.nextInt(3, frameHeight / snakeHeight) * snakeHeight
        val head = SnakeBody(headX, headY, true)
        bodyList.add(head)
        for (i in 1..2) {
            bodyList.add(SnakeBody(head.x + i * snakeWidth, head.y, false))
        }
    }

    /**
     * 画蛇
     */
    fun paintSnake(g: Graphics) {
        for (body in bodyList) {
            g.color = if (body.isHead) Color.orange else Color.green
            g.fillRect(body.x, body.y, snakeWidth, snakeHeight)
        }
    }

    /**
     * 移动蛇，就是把最后一个放到最前面来，需要根据方向来判断下一个位置
     */
    fun move() {
        val last = bodyList.removeLast()
        when (direct) {
            DirectEnum.UP -> {
                last.x = bodyList[0].x
                last.y = bodyList[0].y - snakeWidth
            }

            DirectEnum.DOWN -> {
                last.x = bodyList[0].x
                last.y = bodyList[0].y + snakeWidth
            }

            DirectEnum.LEFT -> {
                last.x = bodyList[0].x - snakeHeight
                last.y = bodyList[0].y
            }

            DirectEnum.RIGHT -> {
                last.x = bodyList[0].x + snakeHeight
                last.y = bodyList[0].y
            }
        }
        last.isHead = true
        bodyList[0].isHead = false
        bodyList.add(0, last)
        if (last.x < 0) last.x = frameWidth
        if (last.x > frameWidth) last.x = 0
        if (last.y < 0) last.y = frameHeight
        if (last.y > frameHeight) last.y = 0
    }

    /**
     * 判断是否吃到食物
     */
    fun isEatSuccess(food: SnakeFood): Boolean {
        return bodyList[0].x == food.x && bodyList[0].y == food.y
    }

    /**
     * 吃食物，就是在最后加一个 body，body 的参数是多少无所谓，因为下一个 move 的时候，会把最后一个放到最前面来
     */
    fun eatFood() {
        val last = bodyList.last()
        bodyList.add(SnakeBody(last.x, last.y, false))
    }

    fun getScore() : Int {
        return bodyList.size
    }
}