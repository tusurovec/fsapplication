package com.example.fsapplication

import retrofit2.Call
import retrofit2.http.GET

interface RetrofitInterface {

    @GET("daily_json.js")
    fun getPosts() : Call<CurrencyResponse>

    companion object {
        const val BASE_URL = "https://www.cbr-xml-daily.ru/"
    }
}