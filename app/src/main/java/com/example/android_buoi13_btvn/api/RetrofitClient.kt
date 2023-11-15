package com.example.android_buoi13_btvn.api

import com.example.android_buoi13_btvn.utils.Constants
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

class RetrofitClient {
    companion object {
        val instances:Retrofit by lazy {
            Retrofit.Builder().baseUrl(Constants.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }

        val getForecastApi:ForecastApi = instances.create(ForecastApi::class.java)
    }
}