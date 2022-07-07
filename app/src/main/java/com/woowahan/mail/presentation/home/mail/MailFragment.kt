package com.woowahan.mail.presentation.home.mail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.woowahan.mail.databinding.FragmentMailBinding

class MailFragment : Fragment() {

    private lateinit var binding: FragmentMailBinding
    private val viewModel: MailViewModel by activityViewModels()
    private val adapter = MailAdapter()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.lifecycleOwner = viewLifecycleOwner
        binding.rvMails.adapter = adapter
        viewModel.getMails()
        observeData()
    }

    private fun observeData() {
        viewModel.mails.observe(viewLifecycleOwner) {
            adapter.submitList(it)
        }
    }
}