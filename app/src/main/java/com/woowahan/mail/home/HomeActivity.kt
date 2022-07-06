package com.woowahan.mail.home

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.FragmentManager
import com.woowahan.mail.R
import com.woowahan.mail.databinding.ActivityHomeBinding
import com.woowahan.mail.home.mail.MailFragment
import com.woowahan.mail.home.mail.primary.PrimaryFragment
import com.woowahan.mail.home.mail.promotion.PromotionFragment
import com.woowahan.mail.home.mail.social.SocialFragment
import com.woowahan.mail.home.settings.SettingsFragment

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
        binding.bnMain.setOnItemSelectedListener { setBottomNavigationListener(it) }
    }

    private fun setBottomNavigationListener(it: MenuItem): Boolean {
        val transaction = supportFragmentManager.beginTransaction()
        when (it.itemId) {
            R.id.navigation_mail -> {
                val mailFragment = MailFragment()
                transaction.replace(R.id.container_view, mailFragment, "mail")
                transaction.addToBackStack("mail")
            }
            R.id.navigation_settings -> {
                val settingsFragment = SettingsFragment()
                transaction.replace(R.id.container_view, settingsFragment, "settings")
                transaction.addToBackStack("settings")
            }
        }
        transaction.commit()
        return true
    }

    private fun setDrawerListener(it: MenuItem): Boolean {
        val transaction = supportFragmentManager.beginTransaction()
        when (it.itemId) {
            R.id.primary -> {
                binding.bnMain.menu.findItem(R.id.navigation_mail).isChecked = true
                val primaryFragment = PrimaryFragment()
                transaction.replace(R.id.container_view, primaryFragment, "primary")
                transaction.addToBackStack("primary")
            }
            R.id.social -> {
                binding.bnMain.menu.findItem(R.id.navigation_mail).isChecked = true
                val socialFragment = SocialFragment()
                transaction.replace(R.id.container_view, socialFragment, "social")
                transaction.addToBackStack("social")
            }
            R.id.promotions -> {
                binding.bnMain.menu.findItem(R.id.navigation_mail).isChecked = true
                val promotionFragment = PromotionFragment()
                transaction.replace(R.id.container_view, promotionFragment, "promotions")
                transaction.addToBackStack("promotions")
            }
        }
        transaction.commit()
        binding.drawerLayout.closeDrawer(binding.nvView)
        return false
    }

    private fun toggleDrawer() {
        if (binding.drawerLayout.isDrawerOpen(GravityCompat.START))
            binding.drawerLayout.closeDrawer(GravityCompat.START)
        else
            binding.drawerLayout.openDrawer(GravityCompat.START)
    }

    private fun updateBottomMenu() {
        val mailTag = supportFragmentManager.findFragmentByTag("mail")
        val settingsTag = supportFragmentManager.findFragmentByTag("settings")
        val primaryTag = supportFragmentManager.findFragmentByTag("primary")
        val socialTag = supportFragmentManager.findFragmentByTag("social")
        val promotionsTag = supportFragmentManager.findFragmentByTag("promotions")

        if (mailTag != null && mailTag.isVisible) {
            binding.bnMain.menu.findItem(R.id.navigation_mail).isChecked = true
        } else if (settingsTag != null && settingsTag.isVisible) {
            binding.bnMain.menu.findItem(R.id.navigation_settings).isChecked = true
        }
        if (primaryTag != null || socialTag != null || promotionsTag != null) {
            supportFragmentManager.popBackStack(null, FragmentManager.POP_BACK_STACK_INCLUSIVE)
        }
    }

    override fun onBackPressed() {
        if (binding.drawerLayout.isDrawerOpen(GravityCompat.START)) {
            binding.drawerLayout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
            updateBottomMenu()
        }
    }
}