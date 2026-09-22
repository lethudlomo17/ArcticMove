package com.example.arcticmove.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.arcticmove.data.DeliveryRepository
import com.example.arcticmove.data.UserRepository
import com.example.arcticmove.screens.BookDeliveryScreen
import com.example.arcticmove.screens.HomeScreen
import com.example.arcticmove.screens.LoginScreen
import com.example.arcticmove.screens.MyOrdersScreen
import com.example.arcticmove.screens.PackageDetailsScreen
import com.example.arcticmove.screens.PinVerificationScreen
import com.example.arcticmove.screens.ProfileSupportScreen
import com.example.arcticmove.screens.QuoteReviewScreen
import com.example.arcticmove.screens.RecipientDetailsScreen
import com.example.arcticmove.screens.RegisterScreen
import com.example.arcticmove.screens.SettingsScreen
import com.example.arcticmove.screens.TrackDeliveryScreen
import com.example.arcticmove.viewmodel.DeliveryViewModel
import kotlinx.coroutines.launch


@Composable
fun AppNavigation() {

    // =========================================
    // NAVIGATION CONTROLLER
    // =========================================

    val navController =
        rememberNavController()


    // =========================================
    // DELIVERY VIEW MODEL
    // =========================================

    val deliveryViewModel:
            DeliveryViewModel = viewModel()


    // =========================================
    // COROUTINE SCOPE
    // =========================================

    val coroutineScope =
        rememberCoroutineScope()


    // =========================================
    // NAVIGATION HOST
    // =========================================

    NavHost(
        navController = navController,
        startDestination = Screen.Login.route
    ) {


        // =====================================
        // LOGIN
        // =====================================

        composable(
            route = Screen.Login.route
        ) {

            LoginScreen(

                onRegisterClick = {

                    navController.navigate(
                        Screen.Register.route
                    )
                },

                onLoginSuccess = {

                    navController.navigate(
                        Screen.Home.route
                    ) {

                        popUpTo(
                            Screen.Login.route
                        ) {
                            inclusive = true
                        }

                        launchSingleTop = true
                    }
                }
            )
        }


        // =====================================
        // REGISTER
        // =====================================

        composable(
            route = Screen.Register.route
        ) {

            RegisterScreen(

                onLoginClick = {

                    navController.popBackStack()
                }
            )
        }


        // =====================================
        // HOME
        // =====================================

        composable(
            route = Screen.Home.route
        ) {

            HomeScreen(

                onBookDeliveryClick = {

                    // Clear old temporary delivery data
                    // before starting a new booking.

                    deliveryViewModel
                        .clearDelivery()


                    navController.navigate(
                        Screen.BookDelivery.route
                    )
                },


                onTrackDeliveryClick = {

                    navController.navigate(
                        Screen.TrackDelivery.route
                    )
                },


                onMyOrdersClick = {

                    navController.navigate(
                        Screen.MyOrders.route
                    )
                },


                onProfileSupportClick = {

                    navController.navigate(
                        Screen.ProfileSupport.route
                    )
                },


                onSettingsClick = {

                    navController.navigate(
                        Screen.Settings.route
                    )
                }
            )
        }


        // =====================================
        // BOOK DELIVERY
        // =====================================

        composable(
            route = Screen.BookDelivery.route
        ) {

            BookDeliveryScreen(

                onContinueClick = {
                        pickupAddress,
                        deliveryAddress ->


                    deliveryViewModel
                        .saveAddresses(
                            pickupAddress =
                                pickupAddress,
                            deliveryAddress =
                                deliveryAddress
                        )


                    navController.navigate(
                        Screen.RecipientDetails.route
                    )
                },


                onBackClick = {

                    navController.popBackStack()
                }
            )
        }


        // =====================================
        // RECIPIENT DETAILS
        // =====================================

        composable(
            route =
                Screen.RecipientDetails.route
        ) {

            RecipientDetailsScreen(

                onContinueClick = {
                        recipientName,
                        recipientPhone,
                        deliveryInstructions ->


                    deliveryViewModel
                        .saveRecipientDetails(
                            recipientName =
                                recipientName,
                            recipientPhone =
                                recipientPhone,
                            deliveryInstructions =
                                deliveryInstructions
                        )


                    navController.navigate(
                        Screen.PackageDetails.route
                    )
                },


                onBackClick = {

                    navController.popBackStack()
                }
            )
        }


        // =====================================
        // PACKAGE DETAILS
        // =====================================

        composable(
            route =
                Screen.PackageDetails.route
        ) {

            PackageDetailsScreen(

                onContinueClick = {
                        packageType,
                        packageDescription,
                        packageWeight ->


                    deliveryViewModel
                        .savePackageDetails(
                            packageType =
                                packageType,
                            packageDescription =
                                packageDescription,
                            packageWeight =
                                packageWeight
                        )


                    navController.navigate(
                        Screen.QuoteReview.route
                    )
                },


                onBackClick = {

                    navController.popBackStack()
                }
            )
        }


        // =====================================
        // QUOTE / REVIEW
        // =====================================

        composable(
            route =
                Screen.QuoteReview.route
        ) {

            QuoteReviewScreen(

                delivery =
                    deliveryViewModel.delivery,


                onConfirmClick = {

                    // Add order ID, fee,
                    // estimated delivery time
                    // and initial status.

                    deliveryViewModel
                        .confirmDelivery()


                    navController.navigate(
                        Screen.PinVerification.route
                    )
                },


                onBackClick = {

                    navController.popBackStack()
                }
            )
        }


        // =====================================
        // PIN VERIFICATION
        // =====================================

        composable(
            route =
                Screen.PinVerification.route
        ) {

            PinVerificationScreen(

                onDoneClick = {

                    coroutineScope.launch {

                        try {

                            // =================================
                            // GET CONFIRMED DELIVERY
                            // =================================

                            val confirmedDelivery =
                                deliveryViewModel.delivery


                            // =================================
                            // SAVE DELIVERY TO ROOM
                            // =================================

                            DeliveryRepository
                                .saveDelivery(
                                    confirmedDelivery
                                )


                            // =================================
                            // RETURN TO HOME
                            // =================================

                            navController.navigate(
                                Screen.Home.route
                            ) {

                                popUpTo(
                                    Screen.Home.route
                                ) {
                                    inclusive = false
                                }

                                launchSingleTop = true
                            }

                        } catch (
                            exception: Exception
                        ) {

                            exception.printStackTrace()
                        }
                    }
                },


                onBackClick = {

                    navController.popBackStack()
                }
            )
        }


        // =====================================
        // TRACK DELIVERY
        // =====================================

        composable(
            route =
                Screen.TrackDelivery.route
        ) {

            TrackDeliveryScreen(

                delivery =
                    deliveryViewModel.delivery,


                onBackClick = {

                    navController.popBackStack()
                }
            )
        }


        // =====================================
        // MY ORDERS
        // =====================================

        composable(
            route =
                Screen.MyOrders.route
        ) {

            /*
             * MyOrdersScreen now loads the
             * logged-in user's deliveries
             * directly from Room.
             *
             * We therefore DO NOT pass
             * deliveryViewModel.delivery here.
             */

            MyOrdersScreen(

                onBackClick = {

                    navController.popBackStack()
                }
            )
        }


        // =====================================
        // PROFILE & SUPPORT
        // =====================================

        composable(
            route =
                Screen.ProfileSupport.route
        ) {

            ProfileSupportScreen(

                onBackClick = {

                    navController.popBackStack()
                },


                onLogoutClick = {

                    // =================================
                    // LOGOUT CURRENT USER
                    // =================================

                    UserRepository
                        .logoutUser()


                    // Clear temporary delivery data.

                    deliveryViewModel
                        .clearDelivery()


                    // =================================
                    // RETURN TO LOGIN
                    // =================================

                    navController.navigate(
                        Screen.Login.route
                    ) {

                        popUpTo(0) {
                            inclusive = true
                        }

                        launchSingleTop = true
                    }
                }
            )
        }


        // =====================================
        // SETTINGS
        // =====================================

        composable(
            route =
                Screen.Settings.route
        ) {

            SettingsScreen(

                onBackClick = {

                    navController.popBackStack()
                }
            )
        }
    }
}