package com.mercadolibre.android.nfc.mvvmexamplefornfcteam.skd

import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.mercadolibre.android.nfc.mvvmexamplefornfcteam.databinding.ActivityFlowConceptTestingBinding
import com.mercadolibre.android.nfc.mvvmexamplefornfcteam.extensions.setToolbar
import com.mercadolibre.android.nfc.mvvmexamplefornfcteam.skd.api.SdkApi
import com.mercadolibre.android.nfc.mvvmexamplefornfcteam.skd.service.SdkInitializerService
import com.mercadolibre.android.nfc.mvvmexamplefornfcteam.skd.viewmodel.FlowConceptTestingViewModel
import com.mercadolibre.android.nfc.mvvmexamplefornfcteam.skd.viewmodel.FlowConceptTestingViewModelFactory
import kotlinx.coroutines.launch

class FlowConceptTesting: AppCompatActivity() {
    private lateinit var binding: ActivityFlowConceptTestingBinding
    private var sdkInitializerService = SdkInitializerService.getInstance(SdkApi.getInstance())
    private val viewModel: FlowConceptTestingViewModel by viewModels {
        FlowConceptTestingViewModelFactory(sdkInitializerService)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFlowConceptTestingBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setToolbar(binding.simpleToolbar.toolbar)
        setPrimaryButton()
        observeSdkStates()
    }

    private fun observeSdkStates() = lifecycleScope.launch {
        viewModel.stateLiveData.observe(this@FlowConceptTesting, { state->
            binding.state.text = state
        })
    }

    private fun setPrimaryButton() = with(binding.primaryButton) {
        text = "Go to other place to see the state"
        setOnClickListener { startActivity(Intent(it.context, OtherStateVisualization::class.java)) }
    }
}