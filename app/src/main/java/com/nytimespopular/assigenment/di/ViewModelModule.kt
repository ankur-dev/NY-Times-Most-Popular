package com.nytimespopular.assigenment.di


import com.nytimespopular.assigenment.ui.viewModel.HomeViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel {
        HomeViewModel(get(), get(), get())
    }
}