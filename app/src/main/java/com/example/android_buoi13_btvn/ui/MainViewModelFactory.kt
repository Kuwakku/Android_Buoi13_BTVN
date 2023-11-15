package com.example.android_buoi13_btvn.ui

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.android_buoi13_btvn.repositories.ForecastRepository

class MainViewModelFactory(private var forecastRepository: ForecastRepository, val application: Application):
    ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return MainViewModel(forecastRepository, application) as T
    }
}