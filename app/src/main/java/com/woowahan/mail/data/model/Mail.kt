package com.woowahan.mail.data.model

import java.util.*

data class Mail(
    val id: Int,
    val sender: String,
    val title: String,
    val content: String,
    val date: String,
    val type: MailType,
    val color: Int? = null,
    val textColor: Int? = null,
    val representative: String? = null,
    val isAlpha: Boolean = false
) {
    fun isAlphabet(): Boolean {
        if (sender.isNotBlank()) {
            if (sender[0] in 'a'..'z' || sender[0] in 'A'..'Z') return true
        }
        return false
    }

    fun getRandom(): Int = Random().nextInt(256)
}