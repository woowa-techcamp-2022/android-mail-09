package com.woowahan.mail.data.repository

import com.woowahan.mail.data.model.Mail
import com.woowahan.mail.data.model.MailType

interface MailRepository {

    suspend fun getMails(): List<Mail>

    suspend fun filterMails(type: MailType): List<Mail>
}