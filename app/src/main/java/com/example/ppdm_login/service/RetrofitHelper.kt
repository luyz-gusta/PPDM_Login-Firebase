package com.example.ppdm_login.service

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitHelper {
    private const val baseUrl = "http://10.107.144.23:3000"

    private val retrofitFactory =
        Retrofit.Builder().
        baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()


}