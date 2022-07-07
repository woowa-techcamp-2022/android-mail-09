package com.woowahan.mail.presentation.home

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.woowahan.mail.R
import com.woowahan.mail.databinding.ActivityHomeBinding
import com.woowahan.mail.presentation.home.mail.primary.PrimaryFragment
import com.woowahan.mail.presentation.home.mail.promotion.PromotionFragment
import com.woowahan.mail.presentation.home.mail.social.SocialFragment
import com.woowahan.mail.presentation.home.settings.SettingsFragment

class HomeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_home)

        initView()
    }

    private fun initView() {
        changeFragment(PrimaryFragment(), getString(R.string.primary))
        binding.tbMail.setNavigationOnClickListener { binding.drawerLayout.openDrawer(GravityCompat.START) }
        binding.nvView.setNavigationItemSelectedListener { setDrawerListener(it) }
        binding.bnMain.setOnItemSelectedListener { setBottomNavigationListener(it) }
    }

    private fun setBottomNavigationListener(it: MenuItem): Boolean {
        when (it.itemId) {
            R.id.navigation_mail -> {
                changeFragment(PrimaryFragment(), getString(R.string.primary))
                return true
            }
            R.id.navigation_settings -> {
                changeFragment(SettingsFragment(), getString(R.string.settings))
                return true
            }
        }
        return false
    }

    private fun setDrawerListener(it: MenuItem): Boolean {
        binding.bnMain.selectedItemId = R.id.navigation_mail
        when (it.itemId) {
            R.id.primary -> changeFragment(PrimaryFragment(), getString(R.string.primary))
            R.id.social -> changeFragment(SocialFragment(), getString(R.string.social))
            R.id.promotions -> changeFragment(PromotionFragment(), getString(R.string.promotions))
        }
        binding.drawerLayout.closeDrawer(binding.nvView)
        return true
    }

    private fun changeFragment(fragment: Fragment, tag: String) {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.container_view, fragment, tag)
        transaction.commit()
        if (tag == getString(R.string.settings)) {
            binding.bnMain.menu.findItem(R.id.navigation_settings).isChecked = true
        } else {
            binding.bnMain.menu.findItem(R.id.navigation_mail).isChecked = true
        }
    }

    override fun onBackPressed() {
        if (binding.drawerLayout.isDrawerOpen(GravityCompat.START)) {
            binding.drawerLayout.closeDrawer(GravityCompat.START)
        } else {
            val fragment = supportFragmentManager.findFragmentByTag(getString(R.string.primary))
            if (fragment == null) {
                changeFragment(PrimaryFragment(), getString(R.string.primary))
                binding.nvView.setCheckedItem(R.id.primary)
            } else {
                super.onBackPressed()
            }
        }
    }
}