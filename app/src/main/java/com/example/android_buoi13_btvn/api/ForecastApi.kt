package com.example.android_buoi13_btvn.api

import com.example.android_buoi13_btvn.models.WeatherForecastResponse
import com.example.android_buoi13_btvn.utils.Constants
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ForecastApi {
    @GET(Constants.FORECAST_URL)
    suspend fun getWeatherForecastByCityName(
        @Query("q") cityName:String,
        @Query("appid") apiKey: String): Response<WeatherForecastResponse>
}