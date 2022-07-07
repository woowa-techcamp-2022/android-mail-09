package com.woowahan.mail.presentation.login

import android.util.Patterns
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.onStart
import java.util.regex.Pattern

class LoginViewModel : ViewModel() {

    val nickname = MutableStateFlow("")

    val email = MutableStateFlow("")

    private val _isNicknameCorrect = MutableStateFlow<Boolean?>(null)
    val isNicknameCorrect: StateFlow<Boolean?> = _isNicknameCorrect

    private val _isEmailCorrect = MutableStateFlow<Boolean?>(null)
    val isEmailCorrect: StateFlow<Boolean?> = _isEmailCorrect

    val isCorrect = combine(isNicknameCorrect, isEmailCorrect) { nickname, email ->
        nickname == true && email == true
    }.onStart { emit(false) }

    fun validateNickname(nickname: String) {
        if (nickname.isEmpty()) {
            _isNicknameCorrect.value = null
            return
        }
        val pattern = "^(?=.*[a-zA-Z])(?=.*[0-9])[0-9a-zA-Z]{4,12}$"
        _isNicknameCorrect.value = Pattern.matches(pattern, nickname)
    }

    fun validateEmail(email: String) {
        if (email.isEmpty()) {
            _isEmailCorrect.value = null
            return
        }
        _isEmailCorrect.value = Patterns.EMAIL_ADDRESS.matcher(email).matches()
    }
}