package com.example.arcticmove.api

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


object RetrofitClient {

    // =========================================
    // LOCAL REST API ADDRESS
    // =========================================
    //
    // 10.0.2.2 allows the Android emulator
    // to communicate with localhost on
    // your Windows computer.
    //
    // We will create the API on port 3000.
    // =========================================

    private const val BASE_URL =
        "http://10.0.2.2:3000/"


    // =========================================
    // HTTP LOGGING
    // =========================================

    private val loggingInterceptor =
        HttpLoggingInterceptor().apply {

            level =
                HttpLoggingInterceptor.Level.BODY
        }


    // =========================================
    // OKHTTP CLIENT
    // =========================================

    private val okHttpClient =
        OkHttpClient.Builder()
            .addInterceptor(
                loggingInterceptor
            )
            .build()


    // =========================================
    // RETROFIT
    // =========================================

    private val retrofit =
        Retrofit.Builder()
            .baseUrl(
                BASE_URL
            )
            .client(
                okHttpClient
            )
            .addConverterFactory(
                GsonConverterFactory.create()
            )
            .build()


    // =========================================
    // ARCTIC MOVE API SERVICE
    // =========================================

    val apiService:
            ArcticMoveApiService by lazy {

        retrofit.create(
            ArcticMoveApiService::class.java
        )
    }
}