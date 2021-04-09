package com.example.fsapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContentView(R.layout.activity_main)

		val repository = CurrencyRepository()
		repository.getCurrencies { currencies ->
			val currencyNames = currencies.map { it.name }

			val adapter = ArrayAdapter<String>(applicationContext, android.R.layout.simple_dropdown_item_1line, currencyNames)
			list_view.adapter = adapter
		}
	}
}