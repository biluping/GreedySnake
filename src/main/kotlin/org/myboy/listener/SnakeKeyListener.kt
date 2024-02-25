package org.myboy.listener

import org.myboy.enums.DirectEnum
import org.myboy.snake.Snake
import java.awt.event.KeyEvent
import java.awt.event.KeyListener

/**
 * keycode 参考
 * 左 37
 * 上 38
 * 右 39
 * 下 40
 * h 72
 * j 74
 * k 75
 * l 76
 */
class SnakeKeyListener(private val snake: Snake) : KeyListener {

    override fun keyPressed(e: KeyEvent) {
        when (e.keyCode) {
            37, 72 -> snake.direct = DirectEnum.LEFT
            38, 75 -> snake.direct = DirectEnum.UP
            39, 76 -> snake.direct = DirectEnum.RIGHT
            40, 74 -> snake.direct = DirectEnum.DOWN
        }
    }

    override fun keyTyped(e: KeyEvent) {
    }


    override fun keyReleased(e: KeyEvent?) {
    }
}