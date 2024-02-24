package org.myboy.frame

import cn.hutool.core.util.RandomUtil
import java.awt.Color
import java.awt.Font
import java.awt.Graphics
import javax.swing.JPanel
import javax.swing.Timer

class GreedySnakePanel : JPanel() {

    init {
        background = Color.WHITE
        Timer(1000) { repaint() }.start()
    }

    override fun paintComponent(g: Graphics) {

        super.paintComponent(g)
        g.font = Font("Bradley Hand", Font.PLAIN, 25)
        g.drawString(RandomUtil.randomString(6), 50, 50)
    }
}