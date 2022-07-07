package com.woowahan.mail.data.model

data class Mail(
    val id: Int,
    val sender: String,
    val title: String,
    val content: String,
    val date: String,
    val type: MailType
)