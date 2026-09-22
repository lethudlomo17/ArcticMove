package com.example.arcticmove.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.arcticmove.data.Delivery

class DeliveryViewModel : ViewModel() {

    // =========================================
    // CURRENT DELIVERY
    // =========================================

    var delivery by mutableStateOf(Delivery())
        private set


    // =========================================
    // SAVE PICKUP & DELIVERY ADDRESSES
    // =========================================

    fun saveAddresses(
        pickupAddress: String,
        deliveryAddress: String
    ) {

        delivery = delivery.copy(
            pickupAddress = pickupAddress,
            deliveryAddress = deliveryAddress
        )
    }


    // =========================================
    // SAVE RECIPIENT DETAILS
    // =========================================

    fun saveRecipientDetails(
        recipientName: String,
        recipientPhone: String,
        deliveryInstructions: String
    ) {

        delivery = delivery.copy(
            recipientName = recipientName,
            recipientPhone = recipientPhone,
            deliveryInstructions = deliveryInstructions
        )
    }


    // =========================================
    // SAVE PACKAGE DETAILS
    // =========================================

    fun savePackageDetails(
        packageType: String,
        packageDescription: String,
        packageWeight: String
    ) {

        delivery = delivery.copy(
            packageType = packageType,
            packageDescription = packageDescription,
            packageWeight = packageWeight
        )
    }


    // =========================================
    // CREATE / CONFIRM DELIVERY
    // =========================================

    fun confirmDelivery() {

        // Generate a unique order number using
        // the current time in milliseconds.
        //
        // Example:
        // AM84567231
        //
        // This prevents every order from using
        // the old hard-coded AM1001 number.

        val uniqueOrderId =
            "AM${System.currentTimeMillis().toString().takeLast(8)}"


        delivery = delivery.copy(
            orderId = uniqueOrderId,
            deliveryFee = "R85",
            estimatedTime = "45 - 60 minutes",
            status = "Order Confirmed"
        )
    }


    // =========================================
    // CLEAR DELIVERY
    // =========================================

    fun clearDelivery() {

        delivery = Delivery()
    }
}