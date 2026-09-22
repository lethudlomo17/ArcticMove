package com.example.arcticmove.navigation

sealed class Screen(val route: String) {

    // =========================================
    // AUTHENTICATION
    // =========================================

    object Login : Screen("login")

    object Register : Screen("register")


    // =========================================
    // HOME
    // =========================================

    object Home : Screen("home")


    // =========================================
    // DELIVERY BOOKING
    // =========================================

    object BookDelivery : Screen("book_delivery")

    object RecipientDetails : Screen("recipient_details")

    object PackageDetails : Screen("package_details")

    object QuoteReview : Screen("quote_review")

    object PinVerification : Screen("pin_verification")


    // =========================================
    // DELIVERY MANAGEMENT
    // =========================================

    object TrackDelivery : Screen("track_delivery")

    object MyOrders : Screen("my_orders")


    // =========================================
    // PROFILE
    // =========================================

    object ProfileSupport : Screen("profile_support")


    // =========================================
    // SETTINGS
    // =========================================

    object Settings : Screen("settings")
}