package org.myboy.frame

import javax.swing.JFrame

class GreedySnakeFrame : JFrame("贪吃蛇") {

    init {
        setLocation(400,200)
        defaultCloseOperation = EXIT_ON_CLOSE
        isResizable = false
        contentPane.add(GreedySnakePanel())
        pack()
        isVisible = true
    }

}