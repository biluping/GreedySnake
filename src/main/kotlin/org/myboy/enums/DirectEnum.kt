package org.myboy.enums

enum class DirectEnum {
    LEFT,RIGHT,UP,DOWN;

    companion object {
        fun randomDirect(): DirectEnum {
            return entries.toTypedArray().random()
        }
    }
}