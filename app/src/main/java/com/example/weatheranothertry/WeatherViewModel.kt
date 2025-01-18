package com.example.weatheranothertry

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.weatheranothertry.api.NetworkResponse
import com.example.weatheranothertry.api.RetrofitInstance
import com.example.weatheranothertry.api.WeatherModel
import kotlinx.coroutines.launch

class WeatherViewModel: ViewModel(){


    private val weatherApi = RetrofitInstance.weatherApi
    private val _weatherData = MutableLiveData< NetworkResponse<WeatherModel>>()
    val weatherData: LiveData<NetworkResponse<WeatherModel>> = _weatherData

    fun getData(city:String){
        _weatherData.value=NetworkResponse.Loading
        viewModelScope.launch {
            try{
                val response = weatherApi.getCurrentWeather(Constant.apiKey,city)
                if(response.isSuccessful){
                    response.body()?.let {
                        _weatherData.value=NetworkResponse.Success(it)
                    }
                }else{
                    _weatherData.value=NetworkResponse.Error("Failed to load data")
                }

            }catch (e:Exception){
                _weatherData.value=NetworkResponse.Error("Failed to load data")
            }

        }

    }
}