package com.example.arcticmove.api

import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Path


interface ArcticMoveApiService {


    // =========================================
    // GET ALL DELIVERIES
    // =========================================

    @GET("deliveries")
    suspend fun getDeliveries():
            Response<List<DeliveryApiModel>>


    // =========================================
    // GET ONE DELIVERY BY ORDER ID
    // =========================================

    @GET("deliveries/{orderId}")
    suspend fun getDeliveryByOrderId(

        @Path("orderId")
        orderId: String

    ): Response<DeliveryApiModel>


    // =========================================
    // CREATE A NEW DELIVERY
    // =========================================

    @POST("deliveries")
    suspend fun createDelivery(

        @Body
        delivery: DeliveryApiModel

    ): Response<DeliveryApiModel>


    // =========================================
    // UPDATE AN EXISTING DELIVERY
    // =========================================

    @PUT("deliveries/{orderId}")
    suspend fun updateDelivery(

        @Path("orderId")
        orderId: String,

        @Body
        delivery: DeliveryApiModel

    ): Response<DeliveryApiModel>
}