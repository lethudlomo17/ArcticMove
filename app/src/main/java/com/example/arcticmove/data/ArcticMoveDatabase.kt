package com.example.arcticmove.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase

@Database(
    entities = [
        UserEntity::class,
        DeliveryEntity::class
    ],
    version = 2,
    exportSchema = false
)
abstract class ArcticMoveDatabase : RoomDatabase() {

    // =========================================
    // USER DATABASE OPERATIONS
    // =========================================

    abstract fun userDao(): UserDao


    // =========================================
    // DELIVERY DATABASE OPERATIONS
    // =========================================

    abstract fun deliveryDao(): DeliveryDao


    companion object {

        @Volatile
        private var INSTANCE: ArcticMoveDatabase? = null


        // =========================================
        // MIGRATION: VERSION 1 -> VERSION 2
        // =========================================

        private val MIGRATION_1_2 =
            object : Migration(1, 2) {

                override fun migrate(
                    database: SupportSQLiteDatabase
                ) {

                    database.execSQL(
                        """
                        CREATE TABLE IF NOT EXISTS `deliveries` (
                            `orderId` TEXT NOT NULL,
                            `userEmail` TEXT NOT NULL,
                            `pickupAddress` TEXT NOT NULL,
                            `deliveryAddress` TEXT NOT NULL,
                            `recipientName` TEXT NOT NULL,
                            `recipientPhone` TEXT NOT NULL,
                            `deliveryInstructions` TEXT NOT NULL,
                            `packageType` TEXT NOT NULL,
                            `packageDescription` TEXT NOT NULL,
                            `packageWeight` TEXT NOT NULL,
                            `deliveryFee` TEXT NOT NULL,
                            `estimatedTime` TEXT NOT NULL,
                            `status` TEXT NOT NULL,
                            PRIMARY KEY(`orderId`)
                        )
                        """.trimIndent()
                    )
                }
            }


        // =========================================
        // GET DATABASE
        // =========================================

        fun getDatabase(
            context: Context
        ): ArcticMoveDatabase {

            return INSTANCE ?: synchronized(this) {

                val instance =
                    Room.databaseBuilder(
                        context.applicationContext,
                        ArcticMoveDatabase::class.java,
                        "arctic_move_database"
                    )
                        .addMigrations(
                            MIGRATION_1_2
                        )
                        .build()

                INSTANCE = instance

                instance
            }
        }
    }
}