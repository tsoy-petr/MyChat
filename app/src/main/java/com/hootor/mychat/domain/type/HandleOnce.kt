package com.hootor.mychat.domain.type

open class HandleOnce<out T>(private val content: T) {

    private var hasBeenHandler = false


    fun getContentIfFoundHandler(): T? {
        return if (hasBeenHandler) {
            null
        } else {
            hasBeenHandler = true
            content
        }
    }
}