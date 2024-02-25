package org.myboy.frame

import org.myboy.food.SnakeFood
import org.myboy.frameHeight
import org.myboy.frameWidth
import org.myboy.listener.SnakeKeyListener
import org.myboy.net.NetUtil
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
        background = Color(0x3a3a3a)
        preferredSize = Dimension(frameWidth, frameHeight)
        // 只有设置了聚焦，键盘事件才能触发
        isFocusable = true
        addKeyListener(SnakeKeyListener(snake))
        snake.generateSnake()
        Timer(1000 / refreshRate) { repaint() }.start()
    }

    override fun paintComponent(g: Graphics) {
        super.paintComponent(g)
        food.paintFood(g)
        snake.move()
        if (snake.isEatSuccess(food)) {
            snake.eatFood()
            food.generateFood()
        }
        NetUtil.paintSnakeList(g, snake.id)
        snake.paintSnake(g)
        drawScore(g)
    }

    private fun drawScore(g: Graphics) {
        g.color = Color.white
        g.font = Font("微软雅黑", Font.PLAIN, 12)
        g.drawString("得分：${snake.getScore()}", frameWidth - 70, 30)
    }

}