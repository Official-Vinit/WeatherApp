package com.example.weatheranothertry.api

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query


//here we define the api and use it in weather instance
interface WeatherApi {
    @GET("v1/current.json")
    suspend fun getCurrentWeather(
        @Query("key") apiKey: String,
        @Query("q") location: String
    ): Response<WeatherModel>


}