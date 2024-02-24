package org.myboy.frame

import javax.swing.JFrame

class GreedySnakeFrame : JFrame("贪吃蛇") {

    init {
        setBounds(30,30, 200, 200)
        defaultCloseOperation = EXIT_ON_CLOSE
        isResizable = false
        add(GreedySnakePanel())
        isVisible = true
    }

}