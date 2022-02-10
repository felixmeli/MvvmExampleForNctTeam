package com.mercadolibre.android.nfc.mvvmexamplefornfcteam

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.mercadolibre.android.nfc.mvvmexamplefornfcteam.databinding.ActivityMainBinding
import com.mercadolibre.android.nfc.mvvmexamplefornfcteam.flows.elephants.ElephantActivity
import com.mercadolibre.android.nfc.mvvmexamplefornfcteam.skd.Cancelacion
import com.mercadolibre.android.nfc.mvvmexamplefornfcteam.skd.FlowConceptTesting

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        setListeners()
        Cancelacion().confing()
    }

    private fun setListeners() {
        binding.elephantButton.setOnClickListener { startActivity(Intent(this, ElephantActivity::class.java)) }
        binding.otherButton.setOnClickListener { startActivity(Intent(this, FlowConceptTesting::class.java)) }
    }
}