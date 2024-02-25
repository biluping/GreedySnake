package org.myboy.frame

import org.myboy.food.SnakeFood
import org.myboy.frameHeight
import org.myboy.frameWidth
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
    private var isStart = false

    init {
        background = Color(0x3a3a3a)
        preferredSize = Dimension(800, 600)
        // 只有设置了聚焦，键盘事件才能触发
        isFocusable = true
        addKeyListener(SnakeKeyListener(snake, this))
        Timer(1000 / refreshRate) { repaint() }.start()
    }

    override fun paintComponent(g: Graphics) {
        super.paintComponent(g)
        if (!isStart) {
            g.color = Color.white
            g.font = Font("微软雅黑", Font.BOLD, 40)
            g.drawString("点击空格开始游戏", frameWidth / 2 - 160, frameHeight / 2 - 20)
        } else {
            snake.move()
        }
        food.paintFood(g)
        if (snake.isEatSuccess(food)) {
            snake.eatFood()
            food.generateFood()
        }
        snake.paintSnake(g)
        drawScore(g)

    }

    fun startOrStop() {
        isStart = !isStart
    }

    private fun drawScore(g: Graphics) {
        g.color = Color.white
        g.font = Font("微软雅黑", Font.PLAIN, 12)
        g.drawString("得分：${snake.getScore()}", frameWidth - 70, 30)
    }

}