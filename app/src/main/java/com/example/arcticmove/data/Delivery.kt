package com.example.arcticmove.data

data class Delivery(

    // Unique delivery/order number
    val orderId: String = "",

    // =========================================
    // DELIVERY ADDRESSES
    // =========================================

    // Where the driver collects the package
    val pickupAddress: String = "",

    // Where the driver delivers the package
    val deliveryAddress: String = "",


    // =========================================
    // RECIPIENT INFORMATION
    // =========================================

    // Person receiving the package
    val recipientName: String = "",

    // Recipient's phone number
    val recipientPhone: String = "",

    // Extra instructions for the driver
    val deliveryInstructions: String = "",


    // =========================================
    // PACKAGE INFORMATION
    // =========================================

    // Example: Documents, Food, Clothing
    val packageType: String = "",

    // Description of the package
    val packageDescription: String = "",

    // Approximate package weight
    val packageWeight: String = "",


    // =========================================
    // DELIVERY INFORMATION
    // =========================================

    // Example: R85
    val deliveryFee: String = "",

    // Example: 45 - 60 minutes
    val estimatedTime: String = "",

    // Example: Order Confirmed / On the Way / Delivered
    val status: String = ""
)