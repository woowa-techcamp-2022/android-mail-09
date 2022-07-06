package com.woowahan.mail.home.mail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.woowahan.mail.databinding.FragmentMailBinding

class MailFragment : Fragment() {

    private lateinit var binding: FragmentMailBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMailBinding.inflate(inflater, container, false)
        return binding.root
    }

}