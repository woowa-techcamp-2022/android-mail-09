package com.woowahan.mail.di

import com.woowahan.mail.presentation.home.mail.MailViewModel
import com.woowahan.mail.presentation.login.LoginViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { LoginViewModel() }
    viewModel { MailViewModel(get()) }
}