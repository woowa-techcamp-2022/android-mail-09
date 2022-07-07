package com.woowahan.mail.presentation.home.settings

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.woowahan.mail.databinding.FragmentSettingsBinding
import com.woowahan.mail.presentation.common.Constant

class SettingsFragment : Fragment() {

    private lateinit var binding: FragmentSettingsBinding
    private val nickname by lazy { arguments?.getString(Constant.NICKNAME) ?: "비회원" }
    private val email by lazy { arguments?.getString(Constant.EMAIL) ?: "없음" }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSettingsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        initView()
    }

    private fun initView() {
        binding.nickname = nickname
        binding.email = email
    }
}