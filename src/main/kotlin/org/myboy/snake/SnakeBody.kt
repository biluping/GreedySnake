package org.myboy.snake

import kotlinx.serialization.Serializable

@Serializable
class SnakeBody(var x: Int, var y: Int, var isHead: Boolean)