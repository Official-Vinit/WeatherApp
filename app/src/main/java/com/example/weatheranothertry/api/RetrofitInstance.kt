package com.example.weatheranothertry.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


// we use (integrate) the api from here
object RetrofitInstance {

    private fun getInstance(): Retrofit{
        return Retrofit.Builder()
            .baseUrl("https://api.weatherapi.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    }

    //from here we can call all the method of weather api with this instance and use in viewmodel
    val weatherApi: WeatherApi = getInstance().create(WeatherApi::class.java)
}