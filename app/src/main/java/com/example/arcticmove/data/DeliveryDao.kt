package com.example.arcticmove.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update

@Dao
interface DeliveryDao {

    // =========================================
    // SAVE A NEW DELIVERY
    // =========================================

    @Insert(onConflict = OnConflictStrategy.ABORT)
    suspend fun insertDelivery(
        delivery: DeliveryEntity
    )


    // =========================================
    // GET ALL ORDERS FOR ONE USER
    // =========================================

    @Query(
        """
        SELECT * FROM deliveries
        WHERE userEmail = :userEmail
        ORDER BY orderId DESC
        """
    )
    suspend fun getDeliveriesForUser(
        userEmail: String
    ): List<DeliveryEntity>


    // =========================================
    // FIND ONE DELIVERY USING ORDER ID
    // =========================================

    @Query(
        """
        SELECT * FROM deliveries
        WHERE orderId = :orderId
        LIMIT 1
        """
    )
    suspend fun getDeliveryByOrderId(
        orderId: String
    ): DeliveryEntity?


    // =========================================
    // UPDATE THE WHOLE DELIVERY
    // =========================================

    @Update
    suspend fun updateDelivery(
        delivery: DeliveryEntity
    )


    // =========================================
    // UPDATE ONLY DELIVERY STATUS
    // =========================================

    @Query(
        """
        UPDATE deliveries
        SET status = :newStatus
        WHERE orderId = :orderId
        """
    )
    suspend fun updateDeliveryStatus(
        orderId: String,
        newStatus: String
    )


    // =========================================
    // DELETE A DELIVERY
    // =========================================

    @Query(
        """
        DELETE FROM deliveries
        WHERE orderId = :orderId
        """
    )
    suspend fun deleteDelivery(
        orderId: String
    )
}