package com.example.arcticmove.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.DarkMode
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.LocalShipping
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Security
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.SupportAgent
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp


@Composable
fun SettingsScreen(
    onBackClick: () -> Unit
) {

    // =========================================
    // SETTINGS STATE
    // =========================================

    var notificationsEnabled by remember {
        mutableStateOf(true)
    }

    var darkModeEnabled by remember {
        mutableStateOf(false)
    }

    var deliveryUpdatesEnabled by remember {
        mutableStateOf(true)
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
            modifier = Modifier.height(20.dp)
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
                    text = "Settings",
                    style = MaterialTheme.typography.headlineMedium,
                    fontWeight = FontWeight.Bold
                )

                Text(
                    text = "Arctic Move",
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }
        }


        Spacer(
            modifier = Modifier.height(32.dp)
        )


        // =========================================
        // HEADER CARD
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
                    .padding(24.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {

                Surface(
                    shape = RoundedCornerShape(18.dp),
                    color = MaterialTheme.colorScheme.primary
                ) {

                    Icon(
                        imageVector = Icons.Default.Settings,
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
                        text = "Your Preferences",
                        style = MaterialTheme.typography.titleLarge,
                        fontWeight = FontWeight.Bold
                    )

                    Spacer(
                        modifier = Modifier.height(4.dp)
                    )

                    Text(
                        text = "Personalise your Arctic Move experience.",
                        style = MaterialTheme.typography.bodyMedium
                    )
                }
            }
        }


        Spacer(
            modifier = Modifier.height(32.dp)
        )


        // =========================================
        // PREFERENCES
        // =========================================

        Text(
            text = "PREFERENCES",
            style = MaterialTheme.typography.labelLarge,
            fontWeight = FontWeight.Bold,
            color = MaterialTheme.colorScheme.primary
        )


        Spacer(
            modifier = Modifier.height(12.dp)
        )


        // =========================================
        // NOTIFICATIONS
        // =========================================

        SettingsSwitchCard(
            icon = Icons.Default.Notifications,
            title = "Notifications",
            description = "Receive important app notifications",
            checked = notificationsEnabled,
            onCheckedChange = {

                notificationsEnabled = it
            }
        )


        Spacer(
            modifier = Modifier.height(12.dp)
        )


        // =========================================
        // DARK MODE
        // =========================================

        SettingsSwitchCard(
            icon = Icons.Default.DarkMode,
            title = "Dark Mode",
            description = "Use a darker Arctic Move appearance",
            checked = darkModeEnabled,
            onCheckedChange = {

                darkModeEnabled = it
            }
        )


        Spacer(
            modifier = Modifier.height(12.dp)
        )


        // =========================================
        // DELIVERY UPDATES
        // =========================================

        SettingsSwitchCard(
            icon = Icons.Default.LocalShipping,
            title = "Delivery Updates",
            description = "Receive updates about your active delivery",
            checked = deliveryUpdatesEnabled,
            onCheckedChange = {

                deliveryUpdatesEnabled = it
            }
        )


        Spacer(
            modifier = Modifier.height(32.dp)
        )


        // =========================================
        // ACCOUNT & SUPPORT
        // =========================================

        Text(
            text = "ACCOUNT & SUPPORT",
            style = MaterialTheme.typography.labelLarge,
            fontWeight = FontWeight.Bold,
            color = MaterialTheme.colorScheme.primary
        )


        Spacer(
            modifier = Modifier.height(12.dp)
        )


        // =========================================
        // PRIVACY & SECURITY
        // =========================================

        SettingsInformationCard(
            icon = Icons.Default.Security,
            title = "Privacy & Security",
            description = "Manage your account security"
        )


        Spacer(
            modifier = Modifier.height(12.dp)
        )


        // =========================================
        // HELP & SUPPORT
        // =========================================

        SettingsInformationCard(
            icon = Icons.Default.SupportAgent,
            title = "Help & Support",
            description = "Get help with Arctic Move"
        )


        Spacer(
            modifier = Modifier.height(12.dp)
        )


        // =========================================
        // ABOUT
        // =========================================

        SettingsInformationCard(
            icon = Icons.Default.Info,
            title = "About Arctic Move",
            description = "App information and version"
        )


        Spacer(
            modifier = Modifier.height(32.dp)
        )


        // =========================================
        // BACK BUTTON
        // =========================================

        Button(
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
                text = "Back to Home",
                fontWeight = FontWeight.Bold
            )
        }


        Spacer(
            modifier = Modifier.height(24.dp)
        )


        // =========================================
        // VERSION
        // =========================================

        Text(
            text = "Arctic Move • Version 1.0",
            modifier = Modifier.align(
                Alignment.CenterHorizontally
            ),
            style = MaterialTheme.typography.bodySmall,
            color = MaterialTheme.colorScheme.onSurfaceVariant
        )


        Spacer(
            modifier = Modifier.height(24.dp)
        )
    }
}


// =============================================
// REUSABLE SWITCH CARD
// =============================================

@Composable
private fun SettingsSwitchCard(
    icon: ImageVector,
    title: String,
    description: String,
    checked: Boolean,
    onCheckedChange: (Boolean) -> Unit
) {

    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(20.dp),
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

            // =====================================
            // ICON CONTAINER
            // =====================================

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
                        .padding(11.dp)
                        .size(24.dp)
                )
            }


            Spacer(
                modifier = Modifier.width(16.dp)
            )


            // =====================================
            // TEXT
            // =====================================

            Column(
                modifier = Modifier.weight(1f)
            ) {

                Text(
                    text = title,
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.SemiBold
                )

                Spacer(
                    modifier = Modifier.height(3.dp)
                )

                Text(
                    text = description,
                    style = MaterialTheme.typography.bodySmall,
                    color =
                        MaterialTheme.colorScheme.onSurfaceVariant
                )
            }


            Spacer(
                modifier = Modifier.width(8.dp)
            )


            // =====================================
            // SWITCH
            // =====================================

            Switch(
                checked = checked,
                onCheckedChange = {

                    onCheckedChange(it)
                }
            )
        }
    }
}


// =============================================
// REUSABLE INFORMATION CARD
// =============================================

@Composable
private fun SettingsInformationCard(
    icon: ImageVector,
    title: String,
    description: String
) {

    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(20.dp),
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

            // =====================================
            // ICON
            // =====================================

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
                        .padding(11.dp)
                        .size(24.dp)
                )
            }


            Spacer(
                modifier = Modifier.width(16.dp)
            )


            // =====================================
            // TEXT
            // =====================================

            Column(
                modifier = Modifier.weight(1f)
            ) {

                Text(
                    text = title,
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.SemiBold
                )

                Spacer(
                    modifier = Modifier.height(3.dp)
                )

                Text(
                    text = description,
                    style = MaterialTheme.typography.bodySmall,
                    color =
                        MaterialTheme.colorScheme.onSurfaceVariant
                )
            }


            // =====================================
            // ARROW
            // =====================================

            Text(
                text = "›",
                style = MaterialTheme.typography.headlineSmall,
                color =
                    MaterialTheme.colorScheme.onSurfaceVariant
            )
        }
    }
}