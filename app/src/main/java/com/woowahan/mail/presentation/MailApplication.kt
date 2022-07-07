package com.woowahan.mail.presentation

import android.app.Application
import com.woowahan.mail.di.repositoryModule
import com.woowahan.mail.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class MailApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger(Level.ERROR)
            androidContext(this@MailApplication)
            modules(viewModelModule + repositoryModule)
        }
    }
}