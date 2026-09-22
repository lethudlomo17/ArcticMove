package com.example.arcticmove.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "deliveries")
data class DeliveryEntity(

    // =========================================
    // ORDER INFORMATION
    // =========================================

    @PrimaryKey
    val orderId: String,


    // =========================================
    // USER / CUSTOMER
    // =========================================

    // Connects this delivery to the logged-in user
    val userEmail: String,


    // =========================================
    // DELIVERY ADDRESSES
    // =========================================

    val pickupAddress: String,

    val deliveryAddress: String,


    // =========================================
    // RECIPIENT INFORMATION
    // =========================================

    val recipientName: String,

    val recipientPhone: String,

    val deliveryInstructions: String,


    // =========================================
    // PACKAGE INFORMATION
    // =========================================

    val packageType: String,

    val packageDescription: String,

    val packageWeight: String,


    // =========================================
    // DELIVERY INFORMATION
    // =========================================

    val deliveryFee: String,

    val estimatedTime: String,

    val status: String
)