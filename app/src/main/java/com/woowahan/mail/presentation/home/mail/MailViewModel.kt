package com.woowahan.mail.presentation.home.mail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.woowahan.mail.data.model.Mail
import com.woowahan.mail.data.model.MailType
import com.woowahan.mail.data.repository.MailDefaultRepository
import com.woowahan.mail.data.repository.MailRepository
import kotlinx.coroutines.launch

class MailViewModel(
    private val mailRepository: MailRepository = MailDefaultRepository()
) : ViewModel() {

    private val _mails = MutableLiveData<List<Mail>>()
    val mails: LiveData<List<Mail>> = _mails

    fun getMails() = viewModelScope.launch {
        val mailList = mailRepository.getMails()
        _mails.value = mailList
    }

    fun filterMails(type: MailType) = viewModelScope.launch {
        val filterList = mailRepository.filterMails(type)
        _mails.value = filterList
    }
}