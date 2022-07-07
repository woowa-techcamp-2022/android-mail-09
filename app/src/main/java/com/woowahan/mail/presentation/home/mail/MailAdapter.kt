package com.woowahan.mail.presentation.home.mail

import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.woowahan.mail.data.model.Mail
import com.woowahan.mail.databinding.ItemMailBinding
import java.util.*

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
            val random = Random()
            val (r, g, b) = listOf(random.nextInt(256), random.nextInt(256), random.nextInt(256))
            binding.mail = mail
            val isAlphabet = isAlphabet(mail.sender)
            binding.isAlphabet = isAlphabet
            binding.color = Color.argb(255, r, g, b)
            binding.textColor = Color.argb(255, (r + r) % 256, (g + g) % 256, (b + b) % 256)
            binding.representative = if (isAlphabet) mail.sender[0].toString() else null
        }

        private fun isAlphabet(sender: String): Boolean {
            if (sender.isNotBlank()) {
                if (sender[0] in 'a'..'z' || sender[0] in 'A'..'Z') return true
            }
            return false
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