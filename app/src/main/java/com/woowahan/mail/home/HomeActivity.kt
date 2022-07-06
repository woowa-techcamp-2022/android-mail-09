package com.woowahan.mail.home

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.core.view.GravityCompat
import androidx.databinding.DataBindingUtil
import com.woowahan.mail.R
import com.woowahan.mail.databinding.ActivityHomeBinding

class HomeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_home)

        initView()
    }

    private fun initView() {
        binding.tbMail.setNavigationOnClickListener { toggleDrawer() }
        binding.nvView.itemIconTintList = null
        binding.nvView.setNavigationItemSelectedListener { setDrawerListener(it) }
    }

    private fun setDrawerListener(it: MenuItem): Boolean {
        when (it.itemId) {
            R.id.primary -> {
                Toast.makeText(this@HomeActivity, "primary", Toast.LENGTH_SHORT).show()
            }
            R.id.social -> {
                Toast.makeText(this@HomeActivity, "social", Toast.LENGTH_SHORT).show()
            }
            R.id.promotions -> {
                Toast.makeText(this@HomeActivity, "promotions", Toast.LENGTH_SHORT).show()
            }
        }
        binding.drawerLayout.closeDrawer(binding.nvView)
        return false
    }

    private fun toggleDrawer() {
        if (binding.drawerLayout.isDrawerOpen(GravityCompat.START))
            binding.drawerLayout.closeDrawer(GravityCompat.START)
        else
            binding.drawerLayout.openDrawer(GravityCompat.START)
    }

    override fun onBackPressed() {
        if (binding.drawerLayout.isDrawerOpen(GravityCompat.START))
            binding.drawerLayout.closeDrawer(GravityCompat.START)
        else
            super.onBackPressed()
    }
}