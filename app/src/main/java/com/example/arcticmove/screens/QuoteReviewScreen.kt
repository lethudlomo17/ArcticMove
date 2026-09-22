package com.example.arcticmove.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.Description
import androidx.compose.material.icons.filled.Inventory2
import androidx.compose.material.icons.filled.LocalShipping
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.MyLocation
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material.icons.filled.Schedule
import androidx.compose.material.icons.filled.Scale
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.arcticmove.data.Delivery


@Composable
fun QuoteReviewScreen(
    delivery: Delivery,
    onConfirmClick: () -> Unit,
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
                    imageVector = Icons.Default.ArrowBack,
                    contentDescription = "Back"
                )
            }


            Spacer(
                modifier = Modifier.width(16.dp)
            )


            Column {

                Text(
                    text = "Review Delivery",
                    style = MaterialTheme.typography.headlineSmall,
                    fontWeight = FontWeight.Bold
                )

                Text(
                    text = "Step 4 of 4",
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }
        }


        Spacer(
            modifier = Modifier.height(28.dp)
        )


        // =========================================
        // PROGRESS BAR - 100%
        // =========================================

        LinearProgressIndicator(
            progress = { 1f },
            modifier = Modifier
                .fillMaxWidth()
                .height(7.dp)
        )


        Spacer(
            modifier = Modifier.height(32.dp)
        )


        // =========================================
        // REVIEW HEADER
        // =========================================

        Card(
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(24.dp),
            colors = CardDefaults.cardColors(
                containerColor =
                    MaterialTheme.colorScheme.primaryContainer
            )
        ) {

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(22.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {

                Surface(
                    shape = RoundedCornerShape(18.dp),
                    color = MaterialTheme.colorScheme.primary
                ) {

                    Icon(
                        imageVector = Icons.Default.CheckCircle,
                        contentDescription = null,
                        tint = MaterialTheme.colorScheme.onPrimary,
                        modifier = Modifier
                            .padding(14.dp)
                            .size(30.dp)
                    )
                }


                Spacer(
                    modifier = Modifier.width(18.dp)
                )


                Column(
                    modifier = Modifier.weight(1f)
                ) {

                    Text(
                        text = "Almost there!",
                        style = MaterialTheme.typography.titleLarge,
                        fontWeight = FontWeight.Bold
                    )

                    Spacer(
                        modifier = Modifier.height(4.dp)
                    )

                    Text(
                        text = "Check everything below before confirming your delivery.",
                        style = MaterialTheme.typography.bodyMedium
                    )
                }
            }
        }


        Spacer(
            modifier = Modifier.height(32.dp)
        )


        // =========================================
        // DELIVERY ROUTE TITLE
        // =========================================

        SectionTitle(
            text = "DELIVERY ROUTE"
        )


        Spacer(
            modifier = Modifier.height(12.dp)
        )


        // =========================================
        // DELIVERY ROUTE CARD
        // =========================================

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

                ReviewDetailRow(
                    icon = Icons.Default.MyLocation,
                    label = "Pickup",
                    value = delivery.pickupAddress
                )


                RouteDivider()


                ReviewDetailRow(
                    icon = Icons.Default.LocationOn,
                    label = "Deliver to",
                    value = delivery.deliveryAddress
                )
            }
        }


        Spacer(
            modifier = Modifier.height(28.dp)
        )


        // =========================================
        // RECIPIENT TITLE
        // =========================================

        SectionTitle(
            text = "RECIPIENT"
        )


        Spacer(
            modifier = Modifier.height(12.dp)
        )


        // =========================================
        // RECIPIENT CARD
        // =========================================

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

                ReviewDetailRow(
                    icon = Icons.Default.Person,
                    label = "Recipient",
                    value = delivery.recipientName
                )


                HorizontalDivider(
                    modifier = Modifier.padding(
                        vertical = 14.dp
                    )
                )


                ReviewDetailRow(
                    icon = Icons.Default.Phone,
                    label = "Phone Number",
                    value = delivery.recipientPhone
                )


                HorizontalDivider(
                    modifier = Modifier.padding(
                        vertical = 14.dp
                    )
                )


                ReviewDetailRow(
                    icon = Icons.Default.Description,
                    label = "Delivery Instructions",
                    value =
                        if (
                            delivery.deliveryInstructions.isBlank()
                        ) {
                            "No special instructions"
                        } else {
                            delivery.deliveryInstructions
                        }
                )
            }
        }


        Spacer(
            modifier = Modifier.height(28.dp)
        )


        // =========================================
        // PACKAGE TITLE
        // =========================================

        SectionTitle(
            text = "PACKAGE DETAILS"
        )


        Spacer(
            modifier = Modifier.height(12.dp)
        )


        // =========================================
        // PACKAGE CARD
        // =========================================

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

                ReviewDetailRow(
                    icon = Icons.Default.Inventory2,
                    label = "Package Type",
                    value = delivery.packageType
                )


                HorizontalDivider(
                    modifier = Modifier.padding(
                        vertical = 14.dp
                    )
                )


                ReviewDetailRow(
                    icon = Icons.Default.Description,
                    label = "Description",
                    value = delivery.packageDescription
                )


                HorizontalDivider(
                    modifier = Modifier.padding(
                        vertical = 14.dp
                    )
                )


                ReviewDetailRow(
                    icon = Icons.Default.Scale,
                    label = "Approximate Weight",
                    value = formatWeight(
                        delivery.packageWeight
                    )
                )
            }
        }


        Spacer(
            modifier = Modifier.height(28.dp)
        )


        // =========================================
        // DELIVERY QUOTE TITLE
        // =========================================

        SectionTitle(
            text = "DELIVERY QUOTE"
        )


        Spacer(
            modifier = Modifier.height(12.dp)
        )


        // =========================================
        // PRICE CARD
        // =========================================

        Card(
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(22.dp),
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
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically
                ) {

                    Surface(
                        shape = RoundedCornerShape(16.dp),
                        color = MaterialTheme.colorScheme.primary
                    ) {

                        Icon(
                            imageVector = Icons.Default.LocalShipping,
                            contentDescription = null,
                            tint =
                                MaterialTheme.colorScheme.onPrimary,
                            modifier = Modifier
                                .padding(12.dp)
                                .size(26.dp)
                        )
                    }


                    Spacer(
                        modifier = Modifier.width(14.dp)
                    )


                    Column(
                        modifier = Modifier.weight(1f)
                    ) {

                        Text(
                            text = "Delivery Fee",
                            style =
                                MaterialTheme.typography.bodyMedium,
                            color =
                                MaterialTheme.colorScheme
                                    .onPrimaryContainer
                        )

                        Text(
                            text = "R85.00",
                            style =
                                MaterialTheme.typography
                                    .headlineMedium,
                            fontWeight = FontWeight.Bold
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


                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {

                    Icon(
                        imageVector = Icons.Default.Schedule,
                        contentDescription = null,
                        tint = MaterialTheme.colorScheme.primary,
                        modifier = Modifier.size(22.dp)
                    )


                    Spacer(
                        modifier = Modifier.width(10.dp)
                    )


                    Column {

                        Text(
                            text = "Estimated delivery",
                            style =
                                MaterialTheme.typography.bodySmall,
                            color =
                                MaterialTheme.colorScheme
                                    .onPrimaryContainer
                        )

                        Text(
                            text = "45 - 60 minutes",
                            style =
                                MaterialTheme.typography.titleMedium,
                            fontWeight = FontWeight.Bold
                        )
                    }
                }
            }
        }


        Spacer(
            modifier = Modifier.height(32.dp)
        )


        // =========================================
        // CONFIRM DELIVERY BUTTON
        // =========================================

        Button(
            onClick = {
                onConfirmClick()
            },
            modifier = Modifier
                .fillMaxWidth()
                .height(58.dp),
            shape = RoundedCornerShape(16.dp)
        ) {

            Icon(
                imageVector = Icons.Default.CheckCircle,
                contentDescription = null
            )


            Spacer(
                modifier = Modifier.width(10.dp)
            )


            Text(
                text = "Confirm Delivery • R85.00",
                fontWeight = FontWeight.Bold
            )
        }


        Spacer(
            modifier = Modifier.height(12.dp)
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
            shape = RoundedCornerShape(16.dp)
        ) {

            Icon(
                imageVector = Icons.Default.ArrowBack,
                contentDescription = null
            )


            Spacer(
                modifier = Modifier.width(8.dp)
            )


            Text(
                text = "Edit Package Details"
            )
        }


        Spacer(
            modifier = Modifier.height(16.dp)
        )


        // =========================================
        // CONFIRMATION MESSAGE
        // =========================================

        Text(
            text = "By confirming, you agree that the delivery details above are correct.",
            style = MaterialTheme.typography.bodySmall,
            color = MaterialTheme.colorScheme.onSurfaceVariant,
            modifier = Modifier.align(
                Alignment.CenterHorizontally
            )
        )


        Spacer(
            modifier = Modifier.height(32.dp)
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
        style = MaterialTheme.typography.labelLarge,
        fontWeight = FontWeight.Bold,
        color = MaterialTheme.colorScheme.primary
    )
}


// =============================================
// REVIEW DETAIL ROW
// =============================================

@Composable
private fun ReviewDetailRow(
    icon: ImageVector,
    label: String,
    value: String
) {

    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.Top
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
                modifier = Modifier.height(3.dp)
            )


            Text(
                text =
                    if (value.isBlank()) {
                        "Not provided"
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
// ROUTE DIVIDER
// =============================================

@Composable
private fun RouteDivider() {

    Row(
        modifier = Modifier.padding(
            start = 20.dp,
            top = 8.dp,
            bottom = 8.dp
        )
    ) {

        Text(
            text = "↓",
            style = MaterialTheme.typography.titleLarge,
            color = MaterialTheme.colorScheme.primary
        )
    }
}


// =============================================
// FORMAT WEIGHT
// =============================================

private fun formatWeight(
    weight: String
): String {

    if (weight.isBlank()) {
        return "Not provided"
    }

    return if (
        weight.contains(
            "kg",
            ignoreCase = true
        )
    ) {

        weight

    } else {

        "$weight kg"
    }
}