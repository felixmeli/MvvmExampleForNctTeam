package com.mercadolibre.android.nfc.mvvmexamplefornfcteam.flows.elephants

import android.view.View
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import com.mercadolibre.android.nfc.mvvmexamplefornfcteam.base.BaseActivity
import com.mercadolibre.android.nfc.mvvmexamplefornfcteam.base.BaseViewModel
import com.mercadolibre.android.nfc.mvvmexamplefornfcteam.databinding.ActivityElephantBinding
import com.mercadolibre.android.nfc.mvvmexamplefornfcteam.extensions.loadurl
import com.mercadolibre.android.nfc.mvvmexamplefornfcteam.flows.elephants.model.ElephantModel
import com.mercadolibre.android.nfc.mvvmexamplefornfcteam.flows.elephants.repository.ElephantRepository
import com.mercadolibre.android.nfc.mvvmexamplefornfcteam.flows.elephants.service.ElephantService
import com.mercadolibre.android.nfc.mvvmexamplefornfcteam.flows.elephants.viewmodel.ElephantViewModel
import com.mercadolibre.android.nfc.mvvmexamplefornfcteam.flows.elephants.viewmodel.ElephantViewModelFactory

class ElephantActivity : BaseActivity<ElephantModel, ActivityElephantBinding>() {
    private val service: ElephantService = ElephantService()
    private val repository: ElephantRepository = ElephantRepository(service)
    private val viewModel: ElephantViewModel by viewModels { ElephantViewModelFactory(repository) }

    override fun onStart() {
        super.onStart()
        addObservers()
        getData()
    }

    override fun getViewBinding(): ActivityElephantBinding = ActivityElephantBinding.inflate(layoutInflater)

    override fun getViewContainer(): Int = binding.viewContainer.id

    override fun getLoadingView(): View = binding.loadingView.root

    override fun getViewModel(): BaseViewModel<ElephantModel> = viewModel

    override fun getRetryAction(): (() -> Unit) = { getData()}

    private fun getData() = viewModel.getElephantModel()

    override fun addOnSuccessObserver() {
        viewModel.onSuccessResponse.observe(this, Observer {
            binding.elephantImage.loadurl(it.img)
            binding.elephantTitle.text = it.title
            binding.elephantDescription.text = it.description
        })
    }

}