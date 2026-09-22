package com.example.arcticmove.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material.icons.filled.LocalShipping
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.MyLocation
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp


@Composable
fun BookDeliveryScreen(
    onContinueClick: (
        pickupAddress: String,
        deliveryAddress: String
    ) -> Unit,
    onBackClick: () -> Unit
) {

    // =========================================
    // TEXT FIELD VALUES
    // =========================================

    var pickupAddress by remember {
        mutableStateOf("")
    }

    var deliveryAddress by remember {
        mutableStateOf("")
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
                    text = "Book a Delivery",
                    style = MaterialTheme.typography.headlineSmall,
                    fontWeight = FontWeight.Bold
                )

                Text(
                    text = "Step 1 of 4",
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }
        }


        Spacer(
            modifier = Modifier.height(28.dp)
        )


        // =========================================
        // PROGRESS BAR
        // =========================================

        LinearProgressIndicator(
            progress = { 0.25f },
            modifier = Modifier
                .fillMaxWidth()
                .height(7.dp),
        )


        Spacer(
            modifier = Modifier.height(32.dp)
        )


        // =========================================
        // DELIVERY HEADER CARD
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
                        imageVector = Icons.Default.LocalShipping,
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


                Column {

                    Text(
                        text = "Plan your route",
                        style = MaterialTheme.typography.titleLarge,
                        fontWeight = FontWeight.Bold
                    )

                    Spacer(
                        modifier = Modifier.height(4.dp)
                    )

                    Text(
                        text = "Tell us where to collect and deliver your package.",
                        style = MaterialTheme.typography.bodyMedium
                    )
                }
            }
        }


        Spacer(
            modifier = Modifier.height(32.dp)
        )


        // =========================================
        // ADDRESS SECTION
        // =========================================

        Text(
            text = "DELIVERY ROUTE",
            style = MaterialTheme.typography.labelLarge,
            fontWeight = FontWeight.Bold,
            color = MaterialTheme.colorScheme.primary
        )


        Spacer(
            modifier = Modifier.height(14.dp)
        )


        // =========================================
        // PICKUP ADDRESS
        // =========================================

        Text(
            text = "Pickup location",
            style = MaterialTheme.typography.titleMedium,
            fontWeight = FontWeight.SemiBold
        )


        Spacer(
            modifier = Modifier.height(8.dp)
        )


        OutlinedTextField(
            value = pickupAddress,
            onValueChange = {
                pickupAddress = it
            },
            label = {
                Text(
                    text = "Pickup Address"
                )
            },
            placeholder = {
                Text(
                    text = "Enter collection address"
                )
            },
            leadingIcon = {

                Icon(
                    imageVector = Icons.Default.MyLocation,
                    contentDescription = null
                )
            },
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(16.dp),
            singleLine = true
        )


        Spacer(
            modifier = Modifier.height(20.dp)
        )


        // =========================================
        // ROUTE CONNECTOR
        // =========================================

        Row(
            modifier = Modifier.padding(
                start = 18.dp
            ),
            verticalAlignment = Alignment.CenterVertically
        ) {

            Text(
                text = "↓",
                style = MaterialTheme.typography.headlineSmall,
                color = MaterialTheme.colorScheme.primary
            )


            Spacer(
                modifier = Modifier.width(12.dp)
            )


            Text(
                text = "Deliver to",
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
        }


        Spacer(
            modifier = Modifier.height(12.dp)
        )


        // =========================================
        // DELIVERY ADDRESS
        // =========================================

        Text(
            text = "Delivery location",
            style = MaterialTheme.typography.titleMedium,
            fontWeight = FontWeight.SemiBold
        )


        Spacer(
            modifier = Modifier.height(8.dp)
        )


        OutlinedTextField(
            value = deliveryAddress,
            onValueChange = {
                deliveryAddress = it
            },
            label = {
                Text(
                    text = "Delivery Address"
                )
            },
            placeholder = {
                Text(
                    text = "Enter destination address"
                )
            },
            leadingIcon = {

                Icon(
                    imageVector = Icons.Default.LocationOn,
                    contentDescription = null
                )
            },
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(16.dp),
            singleLine = true
        )


        Spacer(
            modifier = Modifier.height(28.dp)
        )


        // =========================================
        // INFORMATION CARD
        // =========================================

        Card(
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(18.dp),
            colors = CardDefaults.cardColors(
                containerColor =
                    MaterialTheme.colorScheme.surfaceContainer
            )
        ) {

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(18.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {

                Surface(
                    shape = RoundedCornerShape(14.dp),
                    color =
                        MaterialTheme.colorScheme.secondaryContainer
                ) {

                    Icon(
                        imageVector = Icons.Default.LocalShipping,
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


                Column {

                    Text(
                        text = "Same-day delivery",
                        style = MaterialTheme.typography.titleSmall,
                        fontWeight = FontWeight.Bold
                    )

                    Spacer(
                        modifier = Modifier.height(2.dp)
                    )

                    Text(
                        text = "We'll calculate your delivery details before confirmation.",
                        style = MaterialTheme.typography.bodySmall,
                        color =
                            MaterialTheme.colorScheme.onSurfaceVariant
                    )
                }
            }
        }


        Spacer(
            modifier = Modifier.height(32.dp)
        )


        // =========================================
        // CONTINUE BUTTON
        // =========================================

        Button(
            onClick = {

                onContinueClick(
                    pickupAddress.trim(),
                    deliveryAddress.trim()
                )
            },
            modifier = Modifier
                .fillMaxWidth()
                .height(56.dp),
            shape = RoundedCornerShape(16.dp),

            enabled =
                pickupAddress.isNotBlank() &&
                        deliveryAddress.isNotBlank()
        ) {

            Text(
                text = "Continue",
                fontWeight = FontWeight.Bold
            )


            Spacer(
                modifier = Modifier.width(8.dp)
            )


            Icon(
                imageVector = Icons.Default.ArrowForward,
                contentDescription = null
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
                text = "Back"
            )
        }


        Spacer(
            modifier = Modifier.height(24.dp)
        )
    }
}