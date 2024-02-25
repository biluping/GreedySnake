package org.myboy.net

import cn.hutool.http.HttpUtil
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import org.myboy.food.SnakeFood
import org.myboy.snake.Snake
import java.awt.Graphics

object NetUtil {

    private val host = "http://124.222.165.148:9999"

    private val jsonTool = Json { ignoreUnknownKeys = true }

    fun pullSnakeList(excludeId: String) : List<Snake> {
        val json = HttpUtil.get("$host/snake/list?excludeId=$excludeId")
        return jsonTool.decodeFromString(json)
    }

    fun paintSnakeList(g: Graphics, id: String) {
        val snakeList = pullSnakeList(id)
        for (snake in snakeList) {
            snake.paintSnake(g)
        }
    }

    fun pushSnake(snake: Snake) {
        val json = Json.encodeToString(snake)
        HttpUtil.post("$host/snake/push", json)
    }

    fun pushFood(food: SnakeFood) {
        val json = Json.encodeToString(food)
        var post = HttpUtil.post("$host/food/push", json)
        println(post)
    }

    fun pullFood(): SnakeFood {
        val json = HttpUtil.get("$host/food/pull")
        return Json.decodeFromString(json)
    }
}