package org.myboy.frame

import org.myboy.food.SnakeFood
import org.myboy.listener.SnakeKeyListener
import org.myboy.refreshRate
import org.myboy.snake.Snake
import java.awt.Color
import java.awt.Dimension
import java.awt.Font
import java.awt.Graphics
import javax.swing.JPanel
import javax.swing.Timer

class GreedySnakePanel : JPanel() {

    private val snake = Snake()
    private val food = SnakeFood()

    init {
        background = Color.WHITE
        preferredSize = Dimension(800, 600)
        // 只有设置了聚焦，键盘事件才能触发
        isFocusable = true
        addKeyListener(SnakeKeyListener(snake))
        Timer(1000 / refreshRate) { repaint() }.start()
    }

    override fun paintComponent(g: Graphics) {
        super.paintComponent(g)
        g.font = Font("Bradley Hand", Font.PLAIN, 25)
        food.paintFood(g)
        snake.move()
        if (snake.isEatSuccess(food)) {
            snake.eatFood()
            food.generateFood()
            food.paintFood(g)
        }
        snake.paintSnake(g)
    }
}