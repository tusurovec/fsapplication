package com.example.fsapplication

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class CurrencyRepository {

    fun getCurrencies(onSuccess: (List<Currency>) -> Unit) {
        val retrofit = Retrofit.Builder()
            .baseUrl(RetrofitInterface.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val api = retrofit.create(RetrofitInterface::class.java)
        val call = api.getPosts()

        call.enqueue(object : Callback<CurrencyResponse> {
            override fun onFailure(call: Call<CurrencyResponse>, t: Throwable) {
                t.printStackTrace()
            }

            override fun onResponse(
                call: Call<CurrencyResponse>,
                response: Response<CurrencyResponse>
            ) {
                val currencyResponse = response.body() as CurrencyResponse
                val currencies = currencyResponse.valute.values.toMutableList()

                onSuccess.invoke(currencies)
            }
        })
    }
}