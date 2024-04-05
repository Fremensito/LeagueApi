package com.leagueapi.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.tabs.TabLayoutMediator
import com.leagueapi.databinding.ActivityMainBinding
import com.leagueapi.ui.fragment.MainFragment

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)

        val pixels = resources.displayMetrics.widthPixels
        val xdpi = resources.displayMetrics.xdpi
        val xdp = pixels/(xdpi/160)

        val adapter = PageAdapter(supportFragmentManager, lifecycle)
        val fragment = MainFragment.newInstance(resources.displayMetrics.widthPixels, xdp)
        adapter.addFragment(fragment, "Champions")

        binding.viewPager.adapter = adapter

        TabLayoutMediator(binding.navBar, binding.viewPager){tab, pos ->
            tab.text = adapter.getTitle(pos)
        }.attach()
    }
}