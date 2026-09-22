package com.example.arcticmove.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material.icons.filled.Description
import androidx.compose.material.icons.filled.Inventory2
import androidx.compose.material.icons.filled.LocalShipping
import androidx.compose.material.icons.filled.Scale
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp


@Composable
fun PackageDetailsScreen(
    onContinueClick: (
        packageType: String,
        packageDescription: String,
        packageWeight: String
    ) -> Unit,
    onBackClick: () -> Unit
) {

    // =========================================
    // TEXT FIELD VALUES
    // =========================================

    var packageType by remember {
        mutableStateOf("")
    }

    var packageDescription by remember {
        mutableStateOf("")
    }

    var packageWeight by remember {
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
                    text = "Package Details",
                    style = MaterialTheme.typography.headlineSmall,
                    fontWeight = FontWeight.Bold
                )

                Text(
                    text = "Step 3 of 4",
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }
        }


        Spacer(
            modifier = Modifier.height(28.dp)
        )


        // =========================================
        // PROGRESS BAR - 75%
        // =========================================

        LinearProgressIndicator(
            progress = { 0.75f },
            modifier = Modifier
                .fillMaxWidth()
                .height(7.dp)
        )


        Spacer(
            modifier = Modifier.height(32.dp)
        )


        // =========================================
        // PACKAGE HEADER CARD
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
                        imageVector = Icons.Default.Inventory2,
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
                        text = "What's in the package?",
                        style = MaterialTheme.typography.titleLarge,
                        fontWeight = FontWeight.Bold
                    )

                    Spacer(
                        modifier = Modifier.height(4.dp)
                    )

                    Text(
                        text = "Tell us a little about what we're delivering.",
                        style = MaterialTheme.typography.bodyMedium
                    )
                }
            }
        }


        Spacer(
            modifier = Modifier.height(32.dp)
        )


        // =========================================
        // PACKAGE INFORMATION
        // =========================================

        Text(
            text = "PACKAGE INFORMATION",
            style = MaterialTheme.typography.labelLarge,
            fontWeight = FontWeight.Bold,
            color = MaterialTheme.colorScheme.primary
        )


        Spacer(
            modifier = Modifier.height(14.dp)
        )


        // =========================================
        // PACKAGE TYPE
        // =========================================

        Text(
            text = "Package type",
            style = MaterialTheme.typography.titleMedium,
            fontWeight = FontWeight.SemiBold
        )


        Spacer(
            modifier = Modifier.height(8.dp)
        )


        OutlinedTextField(
            value = packageType,
            onValueChange = {
                packageType = it
            },
            label = {
                Text(
                    text = "Package Type"
                )
            },
            placeholder = {
                Text(
                    text = "e.g. Electronics"
                )
            },
            leadingIcon = {

                Icon(
                    imageVector = Icons.Default.Inventory2,
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
        // PACKAGE DESCRIPTION
        // =========================================

        Text(
            text = "Package description",
            style = MaterialTheme.typography.titleMedium,
            fontWeight = FontWeight.SemiBold
        )


        Spacer(
            modifier = Modifier.height(8.dp)
        )


        OutlinedTextField(
            value = packageDescription,
            onValueChange = {
                packageDescription = it
            },
            label = {
                Text(
                    text = "Description"
                )
            },
            placeholder = {
                Text(
                    text = "e.g. Wireless headphones in a small box"
                )
            },
            leadingIcon = {

                Icon(
                    imageVector = Icons.Default.Description,
                    contentDescription = null
                )
            },
            modifier = Modifier
                .fillMaxWidth()
                .heightIn(
                    min = 130.dp
                ),
            shape = RoundedCornerShape(16.dp),
            minLines = 3
        )


        Spacer(
            modifier = Modifier.height(20.dp)
        )


        // =========================================
        // PACKAGE WEIGHT
        // =========================================

        Text(
            text = "Approximate weight",
            style = MaterialTheme.typography.titleMedium,
            fontWeight = FontWeight.SemiBold
        )


        Spacer(
            modifier = Modifier.height(8.dp)
        )


        OutlinedTextField(
            value = packageWeight,
            onValueChange = {
                packageWeight = it
            },
            label = {
                Text(
                    text = "Weight"
                )
            },
            placeholder = {
                Text(
                    text = "e.g. 2"
                )
            },
            leadingIcon = {

                Icon(
                    imageVector = Icons.Default.Scale,
                    contentDescription = null
                )
            },
            suffix = {
                Text(
                    text = "kg"
                )
            },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Decimal
            ),
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(16.dp),
            singleLine = true
        )


        Spacer(
            modifier = Modifier.height(28.dp)
        )


        // =========================================
        // DELIVERY INFORMATION CARD
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


                Column(
                    modifier = Modifier.weight(1f)
                ) {

                    Text(
                        text = "Why do we need this?",
                        style = MaterialTheme.typography.titleSmall,
                        fontWeight = FontWeight.Bold
                    )

                    Spacer(
                        modifier = Modifier.height(2.dp)
                    )

                    Text(
                        text = "Package information helps us prepare the delivery correctly.",
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
                    packageType.trim(),
                    packageDescription.trim(),
                    packageWeight.trim()
                )
            },
            modifier = Modifier
                .fillMaxWidth()
                .height(56.dp),
            shape = RoundedCornerShape(16.dp),

            // All three package fields are required.
            enabled =
                packageType.isNotBlank() &&
                        packageDescription.isNotBlank() &&
                        packageWeight.isNotBlank()
        ) {

            Text(
                text = "Review Delivery",
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