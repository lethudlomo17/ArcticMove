package com.example.arcticmove

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.arcticmove.data.DeliveryRepository
import com.example.arcticmove.data.UserRepository
import com.example.arcticmove.navigation.AppNavigation
import com.example.arcticmove.ui.theme.ArcticMoveTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        // =========================================
        // INITIALIZE USER DATABASE REPOSITORY
        // =========================================

        UserRepository.initialize(
            applicationContext
        )


        // =========================================
        // INITIALIZE DELIVERY DATABASE REPOSITORY
        // =========================================

        DeliveryRepository.initialize(
            applicationContext
        )


        // =========================================
        // START APP
        // =========================================

        setContent {

            ArcticMoveTheme {

                AppNavigation()
            }
        }
    }
}