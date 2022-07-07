package com.woowahan.mail.presentation.login

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import java.util.regex.Pattern

class LoginViewModel : ViewModel() {

    val nickname = MutableLiveData<String>()

    private val _isCorrect = MutableLiveData<Boolean>()
    val isCorrect: LiveData<Boolean> = _isCorrect

    fun validate(nickname: String) {
        val pattern = """^(?=.*[a-zA-Z])(?=.*[0-9])[0-9a-zA-Z]{4,12}$"""
        _isCorrect.value = Pattern.matches(pattern, nickname)
    }
}