package com.example.android_buoi13_btvn.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.android_buoi13_btvn.R
import com.example.android_buoi13_btvn.api.response.BaseResponse
import com.example.android_buoi13_btvn.repositories.ForecastRepository

class MainActivity : AppCompatActivity() {

    lateinit var mainViewModel: MainViewModel



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val forecastRepository = ForecastRepository()
        val mainViewModelFactory = MainViewModelFactory(forecastRepository, application)
        mainViewModel = ViewModelProvider(this, mainViewModelFactory)[MainViewModel::class.java]

        mainViewModel.getWeatherForecastByCityName("Hà Nội")
        mainViewModel.weatherForecastResult.observe(this, Observer {response ->
            when(response){
                is BaseResponse.Loading-> showLoading()

                is BaseResponse.Success-> {
                    hideLoading()
                    val weatherForecastResponse = response.data
                    Log.d("TAG", "BaseResponse.Success: ${weatherForecastResponse?.city}")

                }

                is BaseResponse.Error->{
                    hideLoading()
                    Log.d("TAG", "BaseResponse.Error: ${response.message}")
                }
            }

        })

    }

    private fun showLoading() {

    }

    private fun hideLoading(){

    }
}