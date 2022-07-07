package com.woowahan.mail.presentation.home.mail

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.woowahan.mail.data.model.Mail
import com.woowahan.mail.databinding.ItemMailBinding

class MailAdapter : ListAdapter<Mail, MailAdapter.MailViewHolder>(DiffUtil) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MailViewHolder {
        val binding = ItemMailBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MailViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MailViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    class MailViewHolder(
        private val binding: ItemMailBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(mail: Mail) {
            binding.mail = mail
        }
    }

    companion object {
        val DiffUtil = object : DiffUtil.ItemCallback<Mail>() {
            override fun areItemsTheSame(oldItem: Mail, newItem: Mail): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: Mail, newItem: Mail): Boolean {
                return oldItem == newItem
            }
        }
    }

}