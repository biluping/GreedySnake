package org.myboy.snake

import java.awt.Color
import java.awt.Graphics

class Snake {

    private val bodyList = arrayListOf<SnakeBody>()
    var direct = DirectEnum.LEFT

    init {
        bodyList.add(SnakeBody(200, 100, true))
        bodyList.add(SnakeBody(210, 100, false))
        bodyList.add(SnakeBody(220, 100, false))
    }

    private fun paintSnake(g: Graphics) {
        for (body in bodyList) {
            if (body.isHead) g.color = Color.orange else g.color = Color.gray
            g.fillRect(body.x, body.y, 10, 10)
        }
    }

    fun paint(g: Graphics) {
        for (body in bodyList) {
            body.x -= 10
        }
        paintSnake(g)
    }

    fun move() {
        bodyList[0].isHead = false
        val last = bodyList.removeLast()
        val head = bodyList.first()
        when (direct) {
            DirectEnum.UP -> {
                last.x = head.x
                last.y = head.y - 10
            }
            DirectEnum.DOWN -> {
                last.x = head.x
                last.y = head.y + 10
            }
            DirectEnum.LEFT -> {
                last.x = head.x - 10
                last.y = head.y
            }
            DirectEnum.RIGHT -> {
                last.x = head.x + 10
                last.y = head.y
            }
        }
        last.isHead = true
        bodyList.add(0, last)
        if (head.x < 0) head.x = 200
        if (head.x > 200) head.x = 0
        if (head.y < 0) head.y = 200
        if(head.y > 200) head.y = 0
    }
}