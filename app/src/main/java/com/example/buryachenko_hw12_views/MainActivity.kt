package com.example.buryachenko_hw12_views

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import com.example.buryachenko_hw12_views.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setupBinding()
        setupListeners()
    }

    private fun setupBinding() {
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    private fun setupListeners() {
        binding.button.setOnClickListener {
            val n = Integer.parseInt(binding.textView.text.toString())

            binding.button.visibility = View.GONE
            binding.textView.visibility = View.GONE
            binding.progressBar.visibility = View.VISIBLE

            Thread(Runnable {
                Thread.sleep((((n + 1) / 10.0) * 1000L).toLong())
                runOnUiThread {
                    updateUI(n)
                }
            }).start()
        }
    }

    private fun updateUI(n: Int) {
        binding.button.visibility = View.VISIBLE
        binding.textView.visibility = View.VISIBLE
        binding.progressBar.visibility = View.GONE
        binding.textView.text = (n + 1).toString()
    }
}