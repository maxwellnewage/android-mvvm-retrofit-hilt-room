package com.example.mvvmapplication.ui.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.core.view.isVisible
import com.example.mvvmapplication.databinding.ActivityMainBinding
import com.example.mvvmapplication.ui.viewmodel.QuoteViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val quoteViewModel: QuoteViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        quoteViewModel.onCreate()

        quoteViewModel.quoteModel.observe(this) {
            binding.tvQuote.text = it.quote
            binding.tvAuthor.text = it.author
        }

        quoteViewModel.isLoading.observe(this) {
            binding.progress.isVisible = it
        }

        binding.viewContainer.setOnClickListener { quoteViewModel.randomQuote() }
    }
}