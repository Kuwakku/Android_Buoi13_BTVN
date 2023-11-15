package com.example.android_buoi13_btvn.repositories

import com.example.android_buoi13_btvn.api.RetrofitClient
import com.example.android_buoi13_btvn.utils.Constants

class ForecastRepository {
    suspend fun getWeatherForecastByCityName(cityName: String) =
        RetrofitClient.getForecastApi.getWeatherForecastByCityName(cityName, Constants.API_KEY)
}