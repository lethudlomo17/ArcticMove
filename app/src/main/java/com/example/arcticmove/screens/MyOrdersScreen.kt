package com.example.arcticmove.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.History
import androidx.compose.material.icons.filled.Inventory2
import androidx.compose.material.icons.filled.LocalShipping
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.MyLocation
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.ReceiptLong
import androidx.compose.material.icons.filled.Schedule
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.arcticmove.data.Delivery
import com.example.arcticmove.data.DeliveryRepository


@Composable
fun MyOrdersScreen(
    onBackClick: () -> Unit
) {

    // =========================================
    // ROOM DATABASE STATE
    // =========================================

    var orders by remember {
        mutableStateOf<List<Delivery>>(emptyList())
    }

    var isLoading by remember {
        mutableStateOf(true)
    }

    var errorMessage by remember {
        mutableStateOf("")
    }


    // =========================================
    // LOAD ORDERS FROM ROOM
    // =========================================

    LaunchedEffect(Unit) {

        isLoading = true
        errorMessage = ""

        try {

            orders =
                DeliveryRepository
                    .getCurrentUserDeliveries()

        } catch (exception: Exception) {

            exception.printStackTrace()

            errorMessage =
                "Unable to load your orders."

        } finally {

            isLoading = false
        }
    }


    // =========================================
    // SEPARATE ACTIVE + PREVIOUS ORDERS
    // =========================================

    val activeOrders =
        orders.filter {
            !it.status.equals(
                "Delivered",
                ignoreCase = true
            )
        }

    val previousOrders =
        orders.filter {
            it.status.equals(
                "Delivered",
                ignoreCase = true
            )
        }


    // =========================================
    // MAIN SCREEN
    // =========================================

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(
                rememberScrollState()
            )
            .padding(
                horizontal = 20.dp,
                vertical = 24.dp
            )
    ) {


        Spacer(
            modifier = Modifier.height(16.dp)
        )


        // =========================================
        // TOP BAR
        // =========================================

        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment =
                Alignment.CenterVertically
        ) {

            FilledTonalIconButton(
                onClick = {
                    onBackClick()
                }
            ) {

                Icon(
                    imageVector =
                        Icons.AutoMirrored.Filled.ArrowBack,
                    contentDescription = "Back"
                )
            }


            Spacer(
                modifier = Modifier.width(16.dp)
            )


            Column {

                Text(
                    text = "My Orders",
                    style =
                        MaterialTheme.typography.headlineSmall,
                    fontWeight = FontWeight.Bold
                )

                Text(
                    text = "Your saved delivery history",
                    style =
                        MaterialTheme.typography.bodyMedium,
                    color =
                        MaterialTheme.colorScheme
                            .onSurfaceVariant
                )
            }
        }


        Spacer(
            modifier = Modifier.height(32.dp)
        )


        // =========================================
        // LOADING
        // =========================================

        if (isLoading) {

            LoadingOrdersCard()

        } else if (errorMessage.isNotEmpty()) {

            OrdersErrorCard(
                message = errorMessage
            )

        } else {


            // =====================================
            // ACTIVE ORDERS
            // =====================================

            SectionTitle(
                text = "ACTIVE DELIVERIES"
            )


            Spacer(
                modifier = Modifier.height(12.dp)
            )


            if (activeOrders.isEmpty()) {

                NoActiveOrderCard()

            } else {

                activeOrders.forEachIndexed {
                        index,
                        delivery ->

                    ActiveOrderCard(
                        delivery = delivery
                    )

                    if (
                        index <
                        activeOrders.lastIndex
                    ) {

                        Spacer(
                            modifier =
                                Modifier.height(16.dp)
                        )
                    }
                }
            }


            Spacer(
                modifier = Modifier.height(32.dp)
            )


            // =====================================
            // PREVIOUS ORDERS HEADER
            // =====================================

            Row(
                modifier =
                    Modifier.fillMaxWidth(),
                verticalAlignment =
                    Alignment.CenterVertically
            ) {

                Text(
                    text = "PREVIOUS ORDERS",
                    style =
                        MaterialTheme.typography.labelLarge,
                    fontWeight = FontWeight.Bold,
                    color =
                        MaterialTheme.colorScheme.primary,
                    modifier =
                        Modifier.weight(1f)
                )


                Icon(
                    imageVector =
                        Icons.Default.History,
                    contentDescription = null,
                    tint =
                        MaterialTheme.colorScheme.primary,
                    modifier =
                        Modifier.size(20.dp)
                )
            }


            Spacer(
                modifier = Modifier.height(12.dp)
            )


            // =====================================
            // REAL PREVIOUS ORDERS FROM ROOM
            // =====================================

            if (previousOrders.isEmpty()) {

                NoPreviousOrdersCard()

            } else {

                previousOrders.forEachIndexed {
                        index,
                        delivery ->

                    PreviousOrderCard(
                        delivery = delivery
                    )

                    if (
                        index <
                        previousOrders.lastIndex
                    ) {

                        Spacer(
                            modifier =
                                Modifier.height(14.dp)
                        )
                    }
                }
            }


            // =====================================
            // DATABASE SUMMARY
            // =====================================

            Spacer(
                modifier = Modifier.height(24.dp)
            )


            Surface(
                modifier =
                    Modifier.fillMaxWidth(),
                shape =
                    RoundedCornerShape(16.dp),
                color =
                    MaterialTheme.colorScheme
                        .surfaceContainer
            ) {

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp),
                    verticalAlignment =
                        Alignment.CenterVertically
                ) {

                    Icon(
                        imageVector =
                            Icons.Default.ReceiptLong,
                        contentDescription = null,
                        tint =
                            MaterialTheme.colorScheme.primary
                    )


                    Spacer(
                        modifier =
                            Modifier.width(12.dp)
                    )


                    Column {

                        Text(
                            text =
                                "${orders.size} saved order" +
                                        if (orders.size == 1) {
                                            ""
                                        } else {
                                            "s"
                                        },
                            fontWeight =
                                FontWeight.Bold
                        )

                        Text(
                            text =
                                "Loaded from your Arctic Move database",
                            style =
                                MaterialTheme.typography.bodySmall,
                            color =
                                MaterialTheme.colorScheme
                                    .onSurfaceVariant
                        )
                    }
                }
            }
        }


        Spacer(
            modifier = Modifier.height(32.dp)
        )


        // =========================================
        // BACK BUTTON
        // =========================================

        OutlinedButton(
            onClick = {
                onBackClick()
            },
            modifier = Modifier
                .fillMaxWidth()
                .height(54.dp),
            shape =
                RoundedCornerShape(16.dp)
        ) {

            Icon(
                imageVector =
                    Icons.AutoMirrored.Filled.ArrowBack,
                contentDescription = null
            )


            Spacer(
                modifier = Modifier.width(8.dp)
            )


            Text(
                text = "Back to Home"
            )
        }


        Spacer(
            modifier = Modifier.height(24.dp)
        )
    }
}


// =============================================
// ACTIVE ORDER CARD
// =============================================

@Composable
private fun ActiveOrderCard(
    delivery: Delivery
) {

    Card(
        modifier = Modifier.fillMaxWidth(),
        shape =
            RoundedCornerShape(26.dp),
        colors =
            CardDefaults.cardColors(
                containerColor =
                    MaterialTheme.colorScheme
                        .primaryContainer
            )
    ) {

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp)
        ) {


            // =====================================
            // ORDER HEADER
            // =====================================

            Row(
                modifier =
                    Modifier.fillMaxWidth(),
                verticalAlignment =
                    Alignment.CenterVertically
            ) {

                Surface(
                    shape =
                        RoundedCornerShape(16.dp),
                    color =
                        MaterialTheme.colorScheme.primary
                ) {

                    Icon(
                        imageVector =
                            Icons.Default.LocalShipping,
                        contentDescription = null,
                        tint =
                            MaterialTheme.colorScheme
                                .onPrimary,
                        modifier = Modifier
                            .padding(12.dp)
                            .size(28.dp)
                    )
                }


                Spacer(
                    modifier =
                        Modifier.width(14.dp)
                )


                Column(
                    modifier =
                        Modifier.weight(1f)
                ) {

                    Text(
                        text =
                            "Order #${delivery.orderId}",
                        style =
                            MaterialTheme.typography
                                .titleLarge,
                        fontWeight =
                            FontWeight.Bold
                    )


                    Spacer(
                        modifier =
                            Modifier.height(3.dp)
                    )


                    Text(
                        text =
                            if (
                                delivery.status
                                    .isBlank()
                            ) {
                                "Order Confirmed"
                            } else {
                                delivery.status
                            },
                        style =
                            MaterialTheme.typography
                                .bodyMedium,
                        color =
                            MaterialTheme.colorScheme
                                .primary,
                        fontWeight =
                            FontWeight.SemiBold
                    )
                }
            }


            Spacer(
                modifier = Modifier.height(20.dp)
            )


            HorizontalDivider()


            Spacer(
                modifier = Modifier.height(18.dp)
            )


            // =====================================
            // PICKUP
            // =====================================

            OrderInformationRow(
                icon =
                    Icons.Default.MyLocation,
                label = "Pickup",
                value =
                    delivery.pickupAddress
            )


            Spacer(
                modifier = Modifier.height(8.dp)
            )


            Row(
                modifier =
                    Modifier.padding(
                        start = 20.dp
                    )
            ) {

                Text(
                    text = "↓",
                    style =
                        MaterialTheme.typography
                            .titleLarge,
                    color =
                        MaterialTheme.colorScheme.primary
                )
            }


            Spacer(
                modifier = Modifier.height(8.dp)
            )


            // =====================================
            // DESTINATION
            // =====================================

            OrderInformationRow(
                icon =
                    Icons.Default.LocationOn,
                label = "Destination",
                value =
                    delivery.deliveryAddress
            )


            Spacer(
                modifier = Modifier.height(18.dp)
            )


            HorizontalDivider()


            Spacer(
                modifier = Modifier.height(18.dp)
            )


            // =====================================
            // RECIPIENT
            // =====================================

            OrderInformationRow(
                icon =
                    Icons.Default.Person,
                label = "Recipient",
                value =
                    delivery.recipientName
            )


            Spacer(
                modifier = Modifier.height(16.dp)
            )


            // =====================================
            // PACKAGE
            // =====================================

            OrderInformationRow(
                icon =
                    Icons.Default.Inventory2,
                label = "Package",
                value =
                    buildPackageText(
                        delivery
                    )
            )


            Spacer(
                modifier = Modifier.height(16.dp)
            )


            // =====================================
            // ETA
            // =====================================

            OrderInformationRow(
                icon =
                    Icons.Default.Schedule,
                label =
                    "Estimated Delivery",
                value =
                    if (
                        delivery.estimatedTime
                            .isBlank()
                    ) {
                        "Not available"
                    } else {
                        delivery.estimatedTime
                    }
            )


            Spacer(
                modifier = Modifier.height(22.dp)
            )


            // =====================================
            // PRICE + STATUS
            // =====================================

            Surface(
                modifier =
                    Modifier.fillMaxWidth(),
                shape =
                    RoundedCornerShape(18.dp),
                color =
                    MaterialTheme.colorScheme.surface
            ) {

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp),
                    verticalAlignment =
                        Alignment.CenterVertically
                ) {

                    Icon(
                        imageVector =
                            Icons.Default.ReceiptLong,
                        contentDescription = null,
                        tint =
                            MaterialTheme.colorScheme.primary,
                        modifier =
                            Modifier.size(24.dp)
                    )


                    Spacer(
                        modifier =
                            Modifier.width(12.dp)
                    )


                    Column(
                        modifier =
                            Modifier.weight(1f)
                    ) {

                        Text(
                            text = "Delivery Fee",
                            style =
                                MaterialTheme.typography
                                    .bodySmall,
                            color =
                                MaterialTheme.colorScheme
                                    .onSurfaceVariant
                        )


                        Text(
                            text =
                                formatPrice(
                                    delivery.deliveryFee
                                ),
                            style =
                                MaterialTheme.typography
                                    .titleLarge,
                            fontWeight =
                                FontWeight.Bold
                        )
                    }


                    Surface(
                        shape =
                            RoundedCornerShape(50.dp),
                        color =
                            MaterialTheme.colorScheme
                                .secondaryContainer
                    ) {

                        Text(
                            text =
                                if (
                                    delivery.status
                                        .isBlank()
                                ) {
                                    "Confirmed"
                                } else {
                                    delivery.status
                                },
                            style =
                                MaterialTheme.typography
                                    .labelMedium,
                            fontWeight =
                                FontWeight.Bold,
                            color =
                                MaterialTheme.colorScheme
                                    .onSecondaryContainer,
                            modifier =
                                Modifier.padding(
                                    horizontal = 12.dp,
                                    vertical = 7.dp
                                )
                        )
                    }
                }
            }
        }
    }
}


// =============================================
// INFORMATION ROW
// =============================================

@Composable
private fun OrderInformationRow(
    icon:
    androidx.compose.ui.graphics.vector.ImageVector,
    label: String,
    value: String
) {

    Row(
        modifier =
            Modifier.fillMaxWidth(),
        verticalAlignment =
            Alignment.CenterVertically
    ) {

        Surface(
            shape =
                RoundedCornerShape(13.dp),
            color =
                MaterialTheme.colorScheme
                    .secondaryContainer
        ) {

            Icon(
                imageVector = icon,
                contentDescription = null,
                tint =
                    MaterialTheme.colorScheme
                        .onSecondaryContainer,
                modifier = Modifier
                    .padding(9.dp)
                    .size(21.dp)
            )
        }


        Spacer(
            modifier = Modifier.width(13.dp)
        )


        Column(
            modifier =
                Modifier.weight(1f)
        ) {

            Text(
                text = label,
                style =
                    MaterialTheme.typography
                        .bodySmall,
                color =
                    MaterialTheme.colorScheme
                        .onSurfaceVariant
            )


            Spacer(
                modifier =
                    Modifier.height(2.dp)
            )


            Text(
                text =
                    if (value.isBlank()) {
                        "Not available"
                    } else {
                        value
                    },
                style =
                    MaterialTheme.typography
                        .bodyLarge,
                fontWeight =
                    FontWeight.SemiBold
            )
        }
    }
}


// =============================================
// PREVIOUS ORDER CARD
// =============================================

@Composable
private fun PreviousOrderCard(
    delivery: Delivery
) {

    Card(
        modifier = Modifier.fillMaxWidth(),
        shape =
            RoundedCornerShape(20.dp),
        colors =
            CardDefaults.cardColors(
                containerColor =
                    MaterialTheme.colorScheme
                        .surfaceContainer
            )
    ) {

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(18.dp)
        ) {

            Row(
                modifier =
                    Modifier.fillMaxWidth(),
                verticalAlignment =
                    Alignment.CenterVertically
            ) {

                Surface(
                    modifier =
                        Modifier.size(42.dp),
                    shape = CircleShape,
                    color =
                        MaterialTheme.colorScheme
                            .secondaryContainer
                ) {

                    Box(
                        modifier =
                            Modifier.fillMaxSize(),
                        contentAlignment =
                            Alignment.Center
                    ) {

                        Icon(
                            imageVector =
                                Icons.Default.History,
                            contentDescription = null,
                            tint =
                                MaterialTheme.colorScheme
                                    .onSecondaryContainer,
                            modifier =
                                Modifier.size(22.dp)
                        )
                    }
                }


                Spacer(
                    modifier =
                        Modifier.width(12.dp)
                )


                Column(
                    modifier =
                        Modifier.weight(1f)
                ) {

                    Text(
                        text =
                            "Order #${delivery.orderId}",
                        style =
                            MaterialTheme.typography
                                .titleMedium,
                        fontWeight =
                            FontWeight.Bold
                    )


                    Text(
                        text =
                            if (
                                delivery.status
                                    .isBlank()
                            ) {
                                "Delivered"
                            } else {
                                delivery.status
                            },
                        style =
                            MaterialTheme.typography
                                .bodySmall,
                        color =
                            MaterialTheme.colorScheme
                                .primary,
                        fontWeight =
                            FontWeight.SemiBold
                    )
                }


                Text(
                    text =
                        formatPrice(
                            delivery.deliveryFee
                        ),
                    style =
                        MaterialTheme.typography
                            .titleMedium,
                    fontWeight =
                        FontWeight.Bold
                )
            }


            Spacer(
                modifier =
                    Modifier.height(16.dp)
            )


            HorizontalDivider()


            Spacer(
                modifier =
                    Modifier.height(14.dp)
            )


            Row(
                verticalAlignment =
                    Alignment.CenterVertically
            ) {

                Icon(
                    imageVector =
                        Icons.Default.MyLocation,
                    contentDescription = null,
                    tint =
                        MaterialTheme.colorScheme.primary,
                    modifier =
                        Modifier.size(18.dp)
                )


                Spacer(
                    modifier =
                        Modifier.width(8.dp)
                )


                Text(
                    text =
                        delivery.pickupAddress,
                    style =
                        MaterialTheme.typography
                            .bodyMedium,
                    modifier =
                        Modifier.weight(1f)
                )
            }


            Spacer(
                modifier =
                    Modifier.height(8.dp)
            )


            Row(
                verticalAlignment =
                    Alignment.CenterVertically
            ) {

                Icon(
                    imageVector =
                        Icons.Default.LocationOn,
                    contentDescription = null,
                    tint =
                        MaterialTheme.colorScheme.primary,
                    modifier =
                        Modifier.size(18.dp)
                )


                Spacer(
                    modifier =
                        Modifier.width(8.dp)
                )


                Text(
                    text =
                        delivery.deliveryAddress,
                    style =
                        MaterialTheme.typography
                            .bodyMedium,
                    modifier =
                        Modifier.weight(1f)
                )
            }
        }
    }
}


// =============================================
// NO ACTIVE ORDERS
// =============================================

@Composable
private fun NoActiveOrderCard() {

    Card(
        modifier =
            Modifier.fillMaxWidth(),
        shape =
            RoundedCornerShape(24.dp),
        colors =
            CardDefaults.cardColors(
                containerColor =
                    MaterialTheme.colorScheme
                        .surfaceContainer
            )
    ) {

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    horizontal = 24.dp,
                    vertical = 32.dp
                ),
            horizontalAlignment =
                Alignment.CenterHorizontally
        ) {

            Surface(
                modifier =
                    Modifier.size(72.dp),
                shape = CircleShape,
                color =
                    MaterialTheme.colorScheme
                        .secondaryContainer
            ) {

                Box(
                    modifier =
                        Modifier.fillMaxSize(),
                    contentAlignment =
                        Alignment.Center
                ) {

                    Icon(
                        imageVector =
                            Icons.Default.LocalShipping,
                        contentDescription = null,
                        tint =
                            MaterialTheme.colorScheme
                                .onSecondaryContainer,
                        modifier =
                            Modifier.size(34.dp)
                    )
                }
            }


            Spacer(
                modifier =
                    Modifier.height(18.dp)
            )


            Text(
                text =
                    "No active deliveries",
                style =
                    MaterialTheme.typography
                        .titleLarge,
                fontWeight =
                    FontWeight.Bold
            )


            Spacer(
                modifier =
                    Modifier.height(8.dp)
            )


            Text(
                text =
                    "Your confirmed deliveries will appear here.",
                style =
                    MaterialTheme.typography
                        .bodyMedium,
                color =
                    MaterialTheme.colorScheme
                        .onSurfaceVariant,
                textAlign =
                    TextAlign.Center
            )
        }
    }
}


// =============================================
// NO PREVIOUS ORDERS
// =============================================

@Composable
private fun NoPreviousOrdersCard() {

    Card(
        modifier =
            Modifier.fillMaxWidth(),
        shape =
            RoundedCornerShape(20.dp),
        colors =
            CardDefaults.cardColors(
                containerColor =
                    MaterialTheme.colorScheme
                        .surfaceContainer
            )
    ) {

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(24.dp),
            horizontalAlignment =
                Alignment.CenterHorizontally
        ) {

            Icon(
                imageVector =
                    Icons.Default.History,
                contentDescription = null,
                tint =
                    MaterialTheme.colorScheme
                        .onSurfaceVariant,
                modifier =
                    Modifier.size(32.dp)
            )


            Spacer(
                modifier =
                    Modifier.height(10.dp)
            )


            Text(
                text =
                    "No previous orders yet",
                style =
                    MaterialTheme.typography
                        .titleMedium,
                fontWeight =
                    FontWeight.Bold
            )


            Spacer(
                modifier =
                    Modifier.height(4.dp)
            )


            Text(
                text =
                    "Completed deliveries will appear here.",
                style =
                    MaterialTheme.typography
                        .bodyMedium,
                color =
                    MaterialTheme.colorScheme
                        .onSurfaceVariant,
                textAlign =
                    TextAlign.Center
            )
        }
    }
}


// =============================================
// LOADING CARD
// =============================================

@Composable
private fun LoadingOrdersCard() {

    Card(
        modifier =
            Modifier.fillMaxWidth(),
        shape =
            RoundedCornerShape(24.dp)
    ) {

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(32.dp),
            horizontalAlignment =
                Alignment.CenterHorizontally
        ) {

            CircularProgressIndicator()


            Spacer(
                modifier =
                    Modifier.height(16.dp)
            )


            Text(
                text =
                    "Loading your orders...",
                style =
                    MaterialTheme.typography
                        .bodyLarge
            )
        }
    }
}


// =============================================
// ERROR CARD
// =============================================

@Composable
private fun OrdersErrorCard(
    message: String
) {

    Surface(
        modifier =
            Modifier.fillMaxWidth(),
        shape =
            RoundedCornerShape(16.dp),
        color =
            MaterialTheme.colorScheme
                .errorContainer
    ) {

        Text(
            text = message,
            color =
                MaterialTheme.colorScheme
                    .onErrorContainer,
            modifier =
                Modifier.padding(18.dp)
        )
    }
}


// =============================================
// SECTION TITLE
// =============================================

@Composable
private fun SectionTitle(
    text: String
) {

    Text(
        text = text,
        style =
            MaterialTheme.typography
                .labelLarge,
        fontWeight =
            FontWeight.Bold,
        color =
            MaterialTheme.colorScheme.primary
    )
}


// =============================================
// PACKAGE DISPLAY
// =============================================

private fun buildPackageText(
    delivery: Delivery
): String {

    val details =
        mutableListOf<String>()

    if (
        delivery.packageType
            .isNotBlank()
    ) {

        details.add(
            delivery.packageType
        )
    }


    if (
        delivery.packageWeight
            .isNotBlank()
    ) {

        details.add(
            delivery.packageWeight
        )
    }


    if (
        delivery.packageDescription
            .isNotBlank()
    ) {

        details.add(
            delivery.packageDescription
        )
    }


    return if (
        details.isEmpty()
    ) {

        "Not available"

    } else {

        details.joinToString(
            separator = " • "
        )
    }
}


// =============================================
// FORMAT DELIVERY PRICE
// =============================================

private fun formatPrice(
    price: String
): String {

    if (price.isBlank()) {
        return "Not available"
    }


    return if (
        price.contains(".")
    ) {

        price

    } else {

        "$price.00"
    }
}