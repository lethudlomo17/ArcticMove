package com.example.arcticmove.api

data class DeliveryApiModel(

    val orderId: String,

    val userEmail: String,

    val pickupAddress: String,

    val deliveryAddress: String,

    val recipientName: String,

    val recipientPhone: String,

    val packageType: String,

    val packageDescription: String,

    val packageWeight: String,

    val deliveryFee: String,

    val estimatedTime: String,

    val status: String,

    val driverName: String = "",

    val driverPhone: String = ""
)