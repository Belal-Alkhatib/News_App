package com.b.alkhatib.mvvmnewsapp.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.setupWithNavController
import com.b.alkhatib.mvvmnewsapp.databinding.ActivityNewsBinding
import kotlinx.android.synthetic.main.activity_news.*
//fd0f5dd150d742dcb72ffa27bc973f13
class NewsActivity : AppCompatActivity() {
    lateinit var binding:ActivityNewsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNewsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.bottomNavigationView.setupWithNavController(newsNavHostFragment.findNavController())
    }
}