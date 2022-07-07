package com.woowahan.mail.presentation.login

import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.woowahan.mail.R
import com.woowahan.mail.databinding.ActivityMainBinding
import com.woowahan.mail.presentation.home.HomeActivity
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val viewModel: LoginViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        initView()
        observeData()
    }

    private fun initView() {
        binding.lifecycleOwner = this
        binding.viewModel = viewModel
        binding.btnNext.setOnClickListener {
            val intent = Intent(this@MainActivity, HomeActivity::class.java)
            startActivity(intent)
            finish()
        }
    }

    private fun observeData() {
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.nickname.collectLatest {
                    viewModel.validateNickname(it)
                }
            }
        }

        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.email.collectLatest {
                    viewModel.validateEmail(it)
                }
            }
        }

        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.isNicknameCorrect.collectLatest {
                    when (it) {
                        false -> invalidNickname()
                        true -> validNickname()
                        else -> binding.etLayoutNickname.isErrorEnabled = false
                    }
                }
            }
        }

        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.isEmailCorrect.collectLatest {
                    when (it) {
                        false -> invalidEmail()
                        true -> validEmail()
                        else -> binding.etLayoutEmail.isErrorEnabled = false
                    }
                }
            }
        }

        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.isCorrect.collectLatest {
                    binding.btnNext.isEnabled = it
                }
            }
        }
    }

    private fun validNickname() = with(binding) {
        etLayoutNickname.isErrorEnabled = false
    }

    private fun validEmail() = with(binding) {
        etLayoutEmail.isErrorEnabled = false
    }

    private fun invalidNickname() = with(binding) {
        etLayoutNickname.error = getString(R.string.nickname_error_message)
        etLayoutNickname.isErrorEnabled = true
        btnNext.isEnabled = false
    }

    private fun invalidEmail() = with(binding) {
        etLayoutEmail.error = getString(R.string.email_error_message)
        etLayoutEmail.isErrorEnabled = true
        btnNext.isEnabled = false
    }

}