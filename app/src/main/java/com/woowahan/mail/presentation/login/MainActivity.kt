package com.woowahan.mail.presentation.login

import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.doAfterTextChanged
import androidx.databinding.DataBindingUtil
import com.woowahan.mail.R
import com.woowahan.mail.databinding.ActivityMainBinding
import com.woowahan.mail.presentation.home.HomeActivity

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
        binding.etLayoutNickname.editText?.doAfterTextChanged {
            viewModel.validate(it.toString())
        }
        binding.btnNext.setOnClickListener {
            val intent = Intent(this@MainActivity, HomeActivity::class.java)
            startActivity(intent)
            finish()
        }
    }

    private fun observeData() {
        viewModel.nickname.observe(this) { nickname ->
            viewModel.validate(nickname)
        }

        viewModel.isCorrect.observe(this) { isCorrect ->
            if (isCorrect)
                validNickname()
            else
                invalidNickname()
        }
    }

    private fun validNickname() = with(binding) {
        etLayoutNickname.isErrorEnabled = false
        btnNext.isEnabled = true
    }

    private fun invalidNickname() = with(binding) {
        etLayoutNickname.error = getString(R.string.nickname_error_message)
        etLayoutNickname.isErrorEnabled = true
        btnNext.isEnabled = false
    }

}