package org.myboy.frame

import org.myboy.listener.SnakeKeyListener
import org.myboy.snake.Snake
import java.awt.Color
import java.awt.Font
import java.awt.Graphics
import javax.swing.JPanel
import javax.swing.Timer

class GreedySnakePanel : JPanel() {

    private val snake = Snake()

    init {
        background = Color.WHITE
        // 只有设置了聚焦，键盘事件才能触发
        isFocusable = true
        addKeyListener(SnakeKeyListener(snake))
        Timer(100) { repaint() }.start()
    }

    override fun paintComponent(g: Graphics) {
        super.paintComponent(g)
        g.font = Font("Bradley Hand", Font.PLAIN, 25)
        snake.move()
        snake.paint(g)
    }
}