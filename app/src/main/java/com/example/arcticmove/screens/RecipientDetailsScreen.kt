package com.example.arcticmove.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material.icons.filled.Badge
import androidx.compose.material.icons.filled.EditNote
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp


@Composable
fun RecipientDetailsScreen(
    onContinueClick: (
        recipientName: String,
        phoneNumber: String,
        deliveryInstructions: String
    ) -> Unit,
    onBackClick: () -> Unit
) {

    // =========================================
    // TEXT FIELD VALUES
    // =========================================

    var recipientName by remember {
        mutableStateOf("")
    }

    var phoneNumber by remember {
        mutableStateOf("")
    }

    var deliveryInstructions by remember {
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
                    text = "Recipient Details",
                    style = MaterialTheme.typography.headlineSmall,
                    fontWeight = FontWeight.Bold
                )

                Text(
                    text = "Step 2 of 4",
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
            progress = { 0.50f },
            modifier = Modifier
                .fillMaxWidth()
                .height(7.dp)
        )


        Spacer(
            modifier = Modifier.height(32.dp)
        )


        // =========================================
        // RECIPIENT HEADER CARD
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
                        imageVector = Icons.Default.Person,
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
                        text = "Who's receiving it?",
                        style = MaterialTheme.typography.titleLarge,
                        fontWeight = FontWeight.Bold
                    )

                    Spacer(
                        modifier = Modifier.height(4.dp)
                    )

                    Text(
                        text = "Add the recipient's contact details so we know who to deliver to.",
                        style = MaterialTheme.typography.bodyMedium
                    )
                }
            }
        }


        Spacer(
            modifier = Modifier.height(32.dp)
        )


        // =========================================
        // CONTACT DETAILS TITLE
        // =========================================

        Text(
            text = "RECIPIENT INFORMATION",
            style = MaterialTheme.typography.labelLarge,
            fontWeight = FontWeight.Bold,
            color = MaterialTheme.colorScheme.primary
        )


        Spacer(
            modifier = Modifier.height(14.dp)
        )


        // =========================================
        // RECIPIENT NAME
        // =========================================

        Text(
            text = "Full name",
            style = MaterialTheme.typography.titleMedium,
            fontWeight = FontWeight.SemiBold
        )


        Spacer(
            modifier = Modifier.height(8.dp)
        )


        OutlinedTextField(
            value = recipientName,
            onValueChange = {
                recipientName = it
            },
            label = {
                Text(
                    text = "Recipient Name"
                )
            },
            placeholder = {
                Text(
                    text = "e.g. Lethukuthula Dlomo"
                )
            },
            leadingIcon = {

                Icon(
                    imageVector = Icons.Default.Badge,
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
        // PHONE NUMBER
        // =========================================

        Text(
            text = "Phone number",
            style = MaterialTheme.typography.titleMedium,
            fontWeight = FontWeight.SemiBold
        )


        Spacer(
            modifier = Modifier.height(8.dp)
        )


        OutlinedTextField(
            value = phoneNumber,
            onValueChange = {
                phoneNumber = it
            },
            label = {
                Text(
                    text = "Phone Number"
                )
            },
            placeholder = {
                Text(
                    text = "e.g. 071 234 5678"
                )
            },
            leadingIcon = {

                Icon(
                    imageVector = Icons.Default.Phone,
                    contentDescription = null
                )
            },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Phone
            ),
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(16.dp),
            singleLine = true
        )


        Spacer(
            modifier = Modifier.height(28.dp)
        )


        // =========================================
        // DELIVERY INSTRUCTIONS TITLE
        // =========================================

        Text(
            text = "DELIVERY INSTRUCTIONS",
            style = MaterialTheme.typography.labelLarge,
            fontWeight = FontWeight.Bold,
            color = MaterialTheme.colorScheme.primary
        )


        Spacer(
            modifier = Modifier.height(14.dp)
        )


        Text(
            text = "Special instructions",
            style = MaterialTheme.typography.titleMedium,
            fontWeight = FontWeight.SemiBold
        )


        Spacer(
            modifier = Modifier.height(8.dp)
        )


        // =========================================
        // DELIVERY INSTRUCTIONS
        // =========================================

        OutlinedTextField(
            value = deliveryInstructions,
            onValueChange = {
                deliveryInstructions = it
            },
            label = {
                Text(
                    text = "Delivery Instructions"
                )
            },
            placeholder = {
                Text(
                    text = "e.g. Call when you arrive at the gate"
                )
            },
            leadingIcon = {

                Icon(
                    imageVector = Icons.Default.EditNote,
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
            modifier = Modifier.height(12.dp)
        )


        Text(
            text = "Optional — leave this blank if there are no special instructions.",
            style = MaterialTheme.typography.bodySmall,
            color = MaterialTheme.colorScheme.onSurfaceVariant
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
                        imageVector = Icons.Default.Phone,
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
                        text = "Keep the recipient reachable",
                        style = MaterialTheme.typography.titleSmall,
                        fontWeight = FontWeight.Bold
                    )

                    Spacer(
                        modifier = Modifier.height(2.dp)
                    )

                    Text(
                        text = "The driver may need to contact them during delivery.",
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
                    recipientName.trim(),
                    phoneNumber.trim(),
                    deliveryInstructions.trim()
                )
            },
            modifier = Modifier
                .fillMaxWidth()
                .height(56.dp),
            shape = RoundedCornerShape(16.dp),

            // Name and phone number are required.
            enabled =
                recipientName.isNotBlank() &&
                        phoneNumber.isNotBlank()
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