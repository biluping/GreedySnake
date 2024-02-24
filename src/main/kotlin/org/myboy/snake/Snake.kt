package org.myboy.snake

import cn.hutool.core.util.RandomUtil
import org.myboy.enums.DirectEnum
import org.myboy.food.SnakeFood
import org.myboy.frameHeight
import org.myboy.frameWidth
import org.myboy.snakeHeight
import org.myboy.snakeWidth
import java.awt.Color
import java.awt.Graphics

class Snake {

    var direct = DirectEnum.LEFT
    private val bodyList = arrayListOf<SnakeBody>()
    private var preLastBody = SnakeBody(0,0,false)

    init {
        generateSnake()
    }

    fun generateSnake() {
        direct = DirectEnum.entries.toTypedArray()[RandomUtil.randomInt(0, 3)]
        val head = SnakeBody(RandomUtil.randomInt(3, frameWidth / snakeWidth) * snakeWidth, RandomUtil.randomInt(3, frameHeight / snakeHeight) * snakeHeight, true)
        val body1 = SnakeBody(head.x + snakeWidth, head.y, false)
        val body2 = SnakeBody(head.x + 2 * snakeWidth, head.y, false)
        bodyList.add(head)
        bodyList.add(body1)
        bodyList.add(body2)
    }

    fun paintSnake(g: Graphics) {
        for (body in bodyList) {
            if (body.isHead) g.color = Color.orange else g.color = Color.green
            g.fillRect(body.x, body.y, snakeWidth, snakeHeight)
        }
    }

    // 往一个方向移动，其实就是把最后一个放到最前面
    fun move() {
        bodyList[0].isHead = false
        val last = bodyList.removeLast()
        // 提前记录一下最后一个body，当吃到食物的时候直接拿这个放到尾部
        preLastBody = SnakeBody(last.x, last.y, false)
        var head = bodyList.first()
        when (direct) {
            DirectEnum.UP -> {
                last.x = head.x
                last.y = head.y - snakeWidth
            }
            DirectEnum.DOWN -> {
                last.x = head.x
                last.y = head.y + snakeWidth
            }
            DirectEnum.LEFT -> {
                last.x = head.x - snakeHeight
                last.y = head.y
            }
            DirectEnum.RIGHT -> {
                last.x = head.x + snakeHeight
                last.y = head.y
            }
        }
        last.isHead = true
        head = last
        bodyList.add(0, head)
        if (head.x < 0) head.x = frameWidth
        if (head.x > frameWidth) head.x = 0
        if (head.y < 0) head.y = frameHeight
        if(head.y >  frameHeight) head.y = 0
    }

    /**
     * 判断是否吃到食物
     */
    fun isEatSuccess(food: SnakeFood) : Boolean {
        val head = bodyList[0]
        return head.x == food.x && head.y == food.y
    }

    fun eatFood() {
        // 在bodyList 尾部添加一个 body
        bodyList.add(preLastBody)
    }
}