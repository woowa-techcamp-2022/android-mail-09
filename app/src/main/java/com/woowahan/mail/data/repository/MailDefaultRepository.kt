package com.woowahan.mail.data.repository

import com.woowahan.mail.data.model.Mail
import com.woowahan.mail.data.model.MailType

class MailDefaultRepository : MailRepository {

    private val mails = DefaultMail.create()

    override suspend fun getMails(): List<Mail> = mails

    override suspend fun filterMails(type: MailType): List<Mail> {
        return when (type) {
            MailType.PRIMARY -> mails.filter { it.type == type }
            MailType.SOCIAL -> mails.filter { it.type == type }
            MailType.PROMOTION -> mails.filter { it.type == type }
        }
    }
}