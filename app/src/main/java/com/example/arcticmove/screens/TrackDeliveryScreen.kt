package com.example.arcticmove.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Inventory2
import androidx.compose.material.icons.filled.LocalShipping
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.MyLocation
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.ReceiptLong
import androidx.compose.material.icons.filled.Schedule
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.arcticmove.data.Delivery


@Composable
fun TrackDeliveryScreen(
    delivery: Delivery,
    onBackClick: () -> Unit
) {

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
            verticalAlignment = Alignment.CenterVertically
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
                    text = "Track Delivery",
                    style =
                        MaterialTheme.typography.headlineSmall,
                    fontWeight = FontWeight.Bold
                )

                Text(
                    text = "Follow your package",
                    style =
                        MaterialTheme.typography.bodyMedium,
                    color =
                        MaterialTheme.colorScheme.onSurfaceVariant
                )
            }
        }


        Spacer(
            modifier = Modifier.height(32.dp)
        )


        // =========================================
        // CHECK FOR ACTIVE DELIVERY
        // =========================================

        if (delivery.orderId.isNotBlank()) {

            ActiveDeliveryContent(
                delivery = delivery
            )

        } else {

            NoActiveDeliveryCard()
        }


        Spacer(
            modifier = Modifier.height(32.dp)
        )


        // =========================================
        // BACK HOME BUTTON
        // =========================================

        OutlinedButton(
            onClick = {
                onBackClick()
            },
            modifier = Modifier
                .fillMaxWidth()
                .height(54.dp),
            shape = RoundedCornerShape(16.dp)
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
// ACTIVE DELIVERY
// =============================================

@Composable
private fun ActiveDeliveryContent(
    delivery: Delivery
) {

    // =========================================
    // CURRENT STATUS CARD
    // =========================================

    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(26.dp),
        colors = CardDefaults.cardColors(
            containerColor =
                MaterialTheme.colorScheme.primaryContainer
        )
    ) {

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(22.dp)
        ) {

            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {

                Surface(
                    shape = RoundedCornerShape(18.dp),
                    color = MaterialTheme.colorScheme.primary
                ) {

                    Icon(
                        imageVector = Icons.Default.LocalShipping,
                        contentDescription = null,
                        tint = MaterialTheme.colorScheme.onPrimary,
                        modifier = Modifier
                            .padding(14.dp)
                            .size(30.dp)
                    )
                }


                Spacer(
                    modifier = Modifier.width(16.dp)
                )


                Column(
                    modifier = Modifier.weight(1f)
                ) {

                    Text(
                        text = "CURRENT STATUS",
                        style =
                            MaterialTheme.typography.labelMedium,
                        fontWeight = FontWeight.Bold,
                        color =
                            MaterialTheme.colorScheme.primary
                    )


                    Spacer(
                        modifier = Modifier.height(4.dp)
                    )


                    Text(
                        text =
                            if (delivery.status.isBlank()) {
                                "Order Confirmed"
                            } else {
                                delivery.status
                            },
                        style =
                            MaterialTheme.typography.titleLarge,
                        fontWeight = FontWeight.Bold
                    )
                }
            }


            Spacer(
                modifier = Modifier.height(22.dp)
            )


            HorizontalDivider()


            Spacer(
                modifier = Modifier.height(18.dp)
            )


            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {

                Icon(
                    imageVector = Icons.Default.ReceiptLong,
                    contentDescription = null,
                    tint = MaterialTheme.colorScheme.primary,
                    modifier = Modifier.size(21.dp)
                )


                Spacer(
                    modifier = Modifier.width(9.dp)
                )


                Column(
                    modifier = Modifier.weight(1f)
                ) {

                    Text(
                        text = "Order number",
                        style =
                            MaterialTheme.typography.bodySmall,
                        color =
                            MaterialTheme.colorScheme
                                .onPrimaryContainer
                    )

                    Text(
                        text = "#${delivery.orderId}",
                        style =
                            MaterialTheme.typography.titleMedium,
                        fontWeight = FontWeight.Bold
                    )
                }


                Icon(
                    imageVector = Icons.Default.Schedule,
                    contentDescription = null,
                    tint = MaterialTheme.colorScheme.primary,
                    modifier = Modifier.size(21.dp)
                )


                Spacer(
                    modifier = Modifier.width(9.dp)
                )


                Column {

                    Text(
                        text = "ETA",
                        style =
                            MaterialTheme.typography.bodySmall,
                        color =
                            MaterialTheme.colorScheme
                                .onPrimaryContainer
                    )

                    Text(
                        text =
                            if (
                                delivery.estimatedTime.isBlank()
                            ) {
                                "45 - 60 min"
                            } else {
                                delivery.estimatedTime
                            },
                        style =
                            MaterialTheme.typography.titleSmall,
                        fontWeight = FontWeight.Bold
                    )
                }
            }
        }
    }


    Spacer(
        modifier = Modifier.height(28.dp)
    )


    // =========================================
    // DELIVERY ROUTE
    // =========================================

    SectionTitle(
        text = "DELIVERY ROUTE"
    )


    Spacer(
        modifier = Modifier.height(12.dp)
    )


    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(20.dp),
        colors = CardDefaults.cardColors(
            containerColor =
                MaterialTheme.colorScheme.surfaceContainer
        )
    ) {

        Column(
            modifier = Modifier.padding(18.dp)
        ) {

            TrackingInfoRow(
                icon = Icons.Default.MyLocation,
                label = "Pickup",
                value = delivery.pickupAddress
            )


            Row(
                modifier = Modifier.padding(
                    start = 20.dp,
                    top = 8.dp,
                    bottom = 8.dp
                )
            ) {

                Text(
                    text = "↓",
                    style =
                        MaterialTheme.typography.titleLarge,
                    color = MaterialTheme.colorScheme.primary
                )
            }


            TrackingInfoRow(
                icon = Icons.Default.LocationOn,
                label = "Destination",
                value = delivery.deliveryAddress
            )
        }
    }


    Spacer(
        modifier = Modifier.height(28.dp)
    )


    // =========================================
    // DELIVERY INFORMATION
    // =========================================

    SectionTitle(
        text = "DELIVERY INFORMATION"
    )


    Spacer(
        modifier = Modifier.height(12.dp)
    )


    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(20.dp),
        colors = CardDefaults.cardColors(
            containerColor =
                MaterialTheme.colorScheme.surfaceContainer
        )
    ) {

        Column(
            modifier = Modifier.padding(18.dp)
        ) {

            TrackingInfoRow(
                icon = Icons.Default.Person,
                label = "Recipient",
                value = delivery.recipientName
            )


            HorizontalDivider(
                modifier = Modifier.padding(
                    vertical = 14.dp
                )
            )


            TrackingInfoRow(
                icon = Icons.Default.Inventory2,
                label = "Package",
                value = delivery.packageType
            )


            HorizontalDivider(
                modifier = Modifier.padding(
                    vertical = 14.dp
                )
            )


            TrackingInfoRow(
                icon = Icons.Default.Schedule,
                label = "Estimated arrival",
                value =
                    if (
                        delivery.estimatedTime.isBlank()
                    ) {
                        "45 - 60 minutes"
                    } else {
                        delivery.estimatedTime
                    }
            )
        }
    }


    Spacer(
        modifier = Modifier.height(28.dp)
    )


    // =========================================
    // DELIVERY PROGRESS
    // =========================================

    SectionTitle(
        text = "DELIVERY PROGRESS"
    )


    Spacer(
        modifier = Modifier.height(12.dp)
    )


    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(22.dp),
        colors = CardDefaults.cardColors(
            containerColor =
                MaterialTheme.colorScheme.surfaceContainer
        )
    ) {

        Column(
            modifier = Modifier.padding(20.dp)
        ) {

            DeliveryTimelineItem(
                title = "Order Confirmed",
                subtitle = "Your delivery has been booked.",
                completed = true,
                showLine = true
            )


            DeliveryTimelineItem(
                title = "Driver Assigned",
                subtitle = "Waiting for a driver.",
                completed = false,
                showLine = true
            )


            DeliveryTimelineItem(
                title = "Package Collected",
                subtitle = "Driver will collect your package.",
                completed = false,
                showLine = true
            )


            DeliveryTimelineItem(
                title = "On the Way",
                subtitle = "Your package will be travelling to its destination.",
                completed = false,
                showLine = true
            )


            DeliveryTimelineItem(
                title = "Delivered",
                subtitle = "Recipient receives the package.",
                completed = false,
                showLine = false
            )
        }
    }


    Spacer(
        modifier = Modifier.height(20.dp)
    )


    // =========================================
    // TRACKING INFORMATION MESSAGE
    // =========================================

    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(18.dp),
        colors = CardDefaults.cardColors(
            containerColor =
                MaterialTheme.colorScheme.secondaryContainer
        )
    ) {

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(18.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {

            Icon(
                imageVector = Icons.Default.LocalShipping,
                contentDescription = null,
                tint =
                    MaterialTheme.colorScheme.onSecondaryContainer,
                modifier = Modifier.size(25.dp)
            )


            Spacer(
                modifier = Modifier.width(14.dp)
            )


            Text(
                text = "Your delivery status will appear here as your package moves through each stage.",
                style = MaterialTheme.typography.bodySmall,
                color =
                    MaterialTheme.colorScheme.onSecondaryContainer
            )
        }
    }
}


// =============================================
// TRACKING INFORMATION ROW
// =============================================

@Composable
private fun TrackingInfoRow(
    icon: ImageVector,
    label: String,
    value: String
) {

    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {

        Surface(
            shape = RoundedCornerShape(14.dp),
            color =
                MaterialTheme.colorScheme.secondaryContainer
        ) {

            Icon(
                imageVector = icon,
                contentDescription = null,
                tint =
                    MaterialTheme.colorScheme.onSecondaryContainer,
                modifier = Modifier
                    .padding(10.dp)
                    .size(22.dp)
            )
        }


        Spacer(
            modifier = Modifier.width(14.dp)
        )


        Column(
            modifier = Modifier.weight(1f)
        ) {

            Text(
                text = label,
                style = MaterialTheme.typography.bodySmall,
                color =
                    MaterialTheme.colorScheme.onSurfaceVariant
            )


            Spacer(
                modifier = Modifier.height(2.dp)
            )


            Text(
                text =
                    if (value.isBlank()) {
                        "Not available"
                    } else {
                        value
                    },
                style = MaterialTheme.typography.bodyLarge,
                fontWeight = FontWeight.SemiBold
            )
        }
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
        style = MaterialTheme.typography.labelLarge,
        fontWeight = FontWeight.Bold,
        color = MaterialTheme.colorScheme.primary
    )
}


// =============================================
// DELIVERY TIMELINE ITEM
// =============================================

@Composable
private fun DeliveryTimelineItem(
    title: String,
    subtitle: String,
    completed: Boolean,
    showLine: Boolean
) {

    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.Top
    ) {

        // =====================================
        // TIMELINE ICON + LINE
        // =====================================

        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Surface(
                modifier = Modifier.size(34.dp),
                shape = CircleShape,
                color =
                    if (completed) {
                        MaterialTheme.colorScheme.primary
                    } else {
                        MaterialTheme.colorScheme
                            .surfaceVariant
                    }
            ) {

                Box(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.Center
                ) {

                    if (completed) {

                        Icon(
                            imageVector = Icons.Default.Check,
                            contentDescription = null,
                            tint =
                                MaterialTheme.colorScheme.onPrimary,
                            modifier = Modifier.size(20.dp)
                        )

                    } else {

                        Box(
                            modifier = Modifier
                                .size(10.dp)
                        ) {

                            Surface(
                                modifier =
                                    Modifier.fillMaxSize(),
                                shape = CircleShape,
                                color =
                                    MaterialTheme.colorScheme
                                        .onSurfaceVariant
                            ) {}
                        }
                    }
                }
            }


            if (showLine) {

                Surface(
                    modifier = Modifier
                        .width(2.dp)
                        .height(48.dp),
                    color =
                        MaterialTheme.colorScheme.outlineVariant
                ) {}
            }
        }


        Spacer(
            modifier = Modifier.width(14.dp)
        )


        // =====================================
        // TIMELINE TEXT
        // =====================================

        Column(
            modifier = Modifier
                .weight(1f)
                .padding(
                    top = 4.dp,
                    bottom =
                        if (showLine) {
                            18.dp
                        } else {
                            4.dp
                        }
                )
        ) {

            Text(
                text = title,
                style = MaterialTheme.typography.titleMedium,
                fontWeight =
                    if (completed) {
                        FontWeight.Bold
                    } else {
                        FontWeight.Medium
                    },
                color =
                    if (completed) {
                        MaterialTheme.colorScheme.primary
                    } else {
                        MaterialTheme.colorScheme.onSurface
                    }
            )


            Spacer(
                modifier = Modifier.height(3.dp)
            )


            Text(
                text = subtitle,
                style = MaterialTheme.typography.bodySmall,
                color =
                    MaterialTheme.colorScheme.onSurfaceVariant
            )
        }
    }
}


// =============================================
// NO ACTIVE DELIVERY
// =============================================

@Composable
private fun NoActiveDeliveryCard() {

    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(26.dp),
        colors = CardDefaults.cardColors(
            containerColor =
                MaterialTheme.colorScheme.surfaceContainer
        )
    ) {

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    horizontal = 24.dp,
                    vertical = 36.dp
                ),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Surface(
                modifier = Modifier.size(78.dp),
                shape = CircleShape,
                color =
                    MaterialTheme.colorScheme.secondaryContainer
            ) {

                Box(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.Center
                ) {

                    Icon(
                        imageVector = Icons.Default.LocalShipping,
                        contentDescription = null,
                        tint =
                            MaterialTheme.colorScheme
                                .onSecondaryContainer,
                        modifier = Modifier.size(38.dp)
                    )
                }
            }


            Spacer(
                modifier = Modifier.height(20.dp)
            )


            Text(
                text = "No active delivery",
                style = MaterialTheme.typography.titleLarge,
                fontWeight = FontWeight.Bold
            )


            Spacer(
                modifier = Modifier.height(8.dp)
            )


            Text(
                text = "Book and confirm a delivery first, then you'll be able to follow its progress here.",
                style = MaterialTheme.typography.bodyMedium,
                color =
                    MaterialTheme.colorScheme.onSurfaceVariant,
                textAlign = TextAlign.Center
            )
        }
    }
}