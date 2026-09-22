package com.example.arcticmove.data

import android.content.Context

object DeliveryRepository {

    // =========================================
    // DELIVERY DAO
    // =========================================

    private lateinit var deliveryDao: DeliveryDao


    // =========================================
    // INITIALIZE REPOSITORY
    // =========================================

    fun initialize(context: Context) {

        val database =
            ArcticMoveDatabase.getDatabase(context)

        deliveryDao =
            database.deliveryDao()
    }


    // =========================================
    // SAVE DELIVERY
    // =========================================

    suspend fun saveDelivery(
        delivery: Delivery
    ) {

        val currentUser =
            UserRepository.getCurrentUser()
                ?: throw IllegalStateException(
                    "No user is currently logged in"
                )


        val deliveryEntity =
            DeliveryEntity(

                orderId =
                    delivery.orderId,

                userEmail =
                    currentUser.email.trim(),

                pickupAddress =
                    delivery.pickupAddress,

                deliveryAddress =
                    delivery.deliveryAddress,

                recipientName =
                    delivery.recipientName,

                recipientPhone =
                    delivery.recipientPhone,

                deliveryInstructions =
                    delivery.deliveryInstructions,

                packageType =
                    delivery.packageType,

                packageDescription =
                    delivery.packageDescription,

                packageWeight =
                    delivery.packageWeight,

                deliveryFee =
                    delivery.deliveryFee,

                estimatedTime =
                    delivery.estimatedTime,

                status =
                    delivery.status
            )


        deliveryDao.insertDelivery(
            deliveryEntity
        )
    }


    // =========================================
    // GET CURRENT USER'S DELIVERIES
    // =========================================

    suspend fun getCurrentUserDeliveries():
            List<Delivery> {

        val currentUser =
            UserRepository.getCurrentUser()
                ?: return emptyList()


        val deliveryEntities =
            deliveryDao.getDeliveriesForUser(
                currentUser.email.trim()
            )


        return deliveryEntities.map { entity ->

            Delivery(

                orderId =
                    entity.orderId,

                pickupAddress =
                    entity.pickupAddress,

                deliveryAddress =
                    entity.deliveryAddress,

                recipientName =
                    entity.recipientName,

                recipientPhone =
                    entity.recipientPhone,

                deliveryInstructions =
                    entity.deliveryInstructions,

                packageType =
                    entity.packageType,

                packageDescription =
                    entity.packageDescription,

                packageWeight =
                    entity.packageWeight,

                deliveryFee =
                    entity.deliveryFee,

                estimatedTime =
                    entity.estimatedTime,

                status =
                    entity.status
            )
        }
    }


    // =========================================
    // GET ONE DELIVERY
    // =========================================

    suspend fun getDeliveryByOrderId(
        orderId: String
    ): Delivery? {

        val entity =
            deliveryDao.getDeliveryByOrderId(
                orderId
            ) ?: return null


        return Delivery(

            orderId =
                entity.orderId,

            pickupAddress =
                entity.pickupAddress,

            deliveryAddress =
                entity.deliveryAddress,

            recipientName =
                entity.recipientName,

            recipientPhone =
                entity.recipientPhone,

            deliveryInstructions =
                entity.deliveryInstructions,

            packageType =
                entity.packageType,

            packageDescription =
                entity.packageDescription,

            packageWeight =
                entity.packageWeight,

            deliveryFee =
                entity.deliveryFee,

            estimatedTime =
                entity.estimatedTime,

            status =
                entity.status
        )
    }


    // =========================================
    // UPDATE DELIVERY STATUS
    // =========================================

    suspend fun updateDeliveryStatus(
        orderId: String,
        newStatus: String
    ) {

        deliveryDao.updateDeliveryStatus(
            orderId = orderId,
            newStatus = newStatus
        )
    }


    // =========================================
    // DELETE DELIVERY
    // =========================================

    suspend fun deleteDelivery(
        orderId: String
    ) {

        deliveryDao.deleteDelivery(
            orderId
        )
    }
}