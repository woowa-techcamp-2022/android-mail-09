package com.woowahan.mail.data.repository

import com.woowahan.mail.data.model.Mail
import com.woowahan.mail.data.model.MailType

class MailDefaultRepository : MailRepository {

    override suspend fun getMails(): List<Mail> {
        return DefaultMail.mails
    }

    override suspend fun filterMails(type: MailType): List<Mail> {
        return when (type) {
            MailType.PRIMARY -> DefaultMail.mails.filter { it.type == type }
            MailType.SOCIAL -> DefaultMail.mails.filter { it.type == type }
            MailType.PROMOTION -> DefaultMail.mails.filter { it.type == type }
        }
    }
}