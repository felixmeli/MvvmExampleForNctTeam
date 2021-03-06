package com.mercadolibre.android.nfc.mvvmexamplefornfcteam

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.mercadolibre.android.nfc.mvvmexamplefornfcteam.databinding.ActivityMainBinding
import com.mercadolibre.android.nfc.mvvmexamplefornfcteam.flows.elephants.ElephantActivity

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        setListeners()
    }

    private fun setListeners() {
        binding.elephantButton.setOnClickListener {
            startActivity(Intent(this, ElephantActivity::class.java))
        }
    }
}