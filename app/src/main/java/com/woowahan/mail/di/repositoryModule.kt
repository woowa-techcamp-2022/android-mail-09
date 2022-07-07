package com.woowahan.mail.di

import com.woowahan.mail.data.repository.MailDefaultRepository
import com.woowahan.mail.data.repository.MailRepository
import org.koin.dsl.module

val repositoryModule = module {
    single<MailRepository> { MailDefaultRepository() }
}