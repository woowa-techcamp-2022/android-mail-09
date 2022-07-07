package com.woowahan.mail.presentation.home.mail.social

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.woowahan.mail.data.model.MailType
import com.woowahan.mail.databinding.FragmentMailBinding
import com.woowahan.mail.presentation.home.mail.MailAdapter
import com.woowahan.mail.presentation.home.mail.MailViewModel

class SocialFragment : Fragment() {

    private val viewModel: MailViewModel by activityViewModels()
    private lateinit var binding: FragmentMailBinding
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
        viewModel.filterMails(MailType.SOCIAL)
        observeData()
    }

    private fun observeData() {
        viewModel.mails.observe(viewLifecycleOwner) {
            adapter.submitList(it)
        }
    }
}