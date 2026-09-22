package com.example.arcticmove.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material.icons.filled.Inventory2
import androidx.compose.material.icons.filled.LocalShipping
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.arcticmove.R


@Composable
fun HomeScreen(
    onBookDeliveryClick: () -> Unit,
    onTrackDeliveryClick: () -> Unit,
    onMyOrdersClick: () -> Unit,
    onProfileSupportClick: () -> Unit,
    onSettingsClick: () -> Unit
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
        // TOP HEADER
        // =========================================

        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {

            // =====================================
            // ARCTIC MOVE LOGO
            // =====================================

            Surface(
                shape = RoundedCornerShape(18.dp),
                color = MaterialTheme.colorScheme.primaryContainer
            ) {

                Image(
                    painter = painterResource(
                        id = R.drawable.arctic_move_logo
                    ),
                    contentDescription = "Arctic Move Logo",
                    contentScale = ContentScale.Fit,
                    modifier = Modifier
                        .size(64.dp)
                        .padding(6.dp)
                )
            }


            Spacer(
                modifier = Modifier.width(14.dp)
            )


            // =====================================
            // APP NAME
            // =====================================

            Column(
                modifier = Modifier.weight(1f)
            ) {

                Text(
                    text = "Arctic Move",
                    style = MaterialTheme.typography.headlineSmall,
                    fontWeight = FontWeight.Bold
                )

                Text(
                    text = "Fast. Safe. Delivered.",
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }


            // =====================================
            // SETTINGS SHORTCUT
            // =====================================

            FilledTonalIconButton(
                onClick = {
                    onSettingsClick()
                }
            ) {

                Icon(
                    imageVector = Icons.Default.Settings,
                    contentDescription = "Settings"
                )
            }
        }


        Spacer(
            modifier = Modifier.height(32.dp)
        )


        // =========================================
        // WELCOME SECTION
        // =========================================

        Text(
            text = "Welcome to Arctic Move 👋",
            style = MaterialTheme.typography.headlineSmall,
            fontWeight = FontWeight.Bold
        )

        Spacer(
            modifier = Modifier.height(6.dp)
        )

        Text(
            text = "Where are we delivering today?",
            style = MaterialTheme.typography.bodyLarge,
            color = MaterialTheme.colorScheme.onSurfaceVariant
        )


        Spacer(
            modifier = Modifier.height(28.dp)
        )


        // =========================================
        // BOOK DELIVERY HERO CARD
        // =========================================

        Card(
            modifier = Modifier
                .fillMaxWidth()
                .clickable {
                    onBookDeliveryClick()
                },
            shape = RoundedCornerShape(26.dp),
            colors = CardDefaults.cardColors(
                containerColor =
                    MaterialTheme.colorScheme.primaryContainer
            )
        ) {

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(24.dp)
            ) {

                // =================================
                // DELIVERY ICON
                // =================================

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
                    modifier = Modifier.height(20.dp)
                )


                Text(
                    text = "Book a Delivery",
                    style = MaterialTheme.typography.headlineSmall,
                    fontWeight = FontWeight.Bold
                )


                Spacer(
                    modifier = Modifier.height(6.dp)
                )


                Text(
                    text = "Send your package quickly and safely with Arctic Move.",
                    style = MaterialTheme.typography.bodyMedium,
                    color =
                        MaterialTheme.colorScheme.onPrimaryContainer
                )


                Spacer(
                    modifier = Modifier.height(20.dp)
                )


                Button(
                    onClick = {
                        onBookDeliveryClick()
                    },
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(16.dp)
                ) {

                    Text(
                        text = "Start Delivery",
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
            }
        }


        Spacer(
            modifier = Modifier.height(32.dp)
        )


        // =========================================
        // QUICK ACTIONS TITLE
        // =========================================

        Text(
            text = "QUICK ACTIONS",
            style = MaterialTheme.typography.labelLarge,
            fontWeight = FontWeight.Bold,
            color = MaterialTheme.colorScheme.primary
        )


        Spacer(
            modifier = Modifier.height(14.dp)
        )


        // =========================================
        // FIRST QUICK ACTION ROW
        // =========================================

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(12.dp)
        ) {

            HomeActionCard(
                modifier = Modifier.weight(1f),
                icon = Icons.Default.LocationOn,
                title = "Track",
                subtitle = "Delivery",
                onClick = {
                    onTrackDeliveryClick()
                }
            )


            HomeActionCard(
                modifier = Modifier.weight(1f),
                icon = Icons.Default.Inventory2,
                title = "My",
                subtitle = "Orders",
                onClick = {
                    onMyOrdersClick()
                }
            )
        }


        Spacer(
            modifier = Modifier.height(12.dp)
        )


        // =========================================
        // SECOND QUICK ACTION ROW
        // =========================================

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(12.dp)
        ) {

            HomeActionCard(
                modifier = Modifier.weight(1f),
                icon = Icons.Default.Person,
                title = "Profile",
                subtitle = "& Support",
                onClick = {
                    onProfileSupportClick()
                }
            )


            HomeActionCard(
                modifier = Modifier.weight(1f),
                icon = Icons.Default.Settings,
                title = "App",
                subtitle = "Settings",
                onClick = {
                    onSettingsClick()
                }
            )
        }


        Spacer(
            modifier = Modifier.height(32.dp)
        )


        // =========================================
        // DELIVERY INFO CARD
        // =========================================

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
                            .padding(11.dp)
                            .size(24.dp)
                    )
                }


                Spacer(
                    modifier = Modifier.width(14.dp)
                )


                Column {

                    Text(
                        text = "Same-day delivery",
                        style = MaterialTheme.typography.titleMedium,
                        fontWeight = FontWeight.SemiBold
                    )

                    Spacer(
                        modifier = Modifier.height(3.dp)
                    )

                    Text(
                        text = "Fast and reliable parcel delivery.",
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
        // APP VERSION
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
// REUSABLE HOME ACTION CARD
// =============================================

@Composable
private fun HomeActionCard(
    modifier: Modifier = Modifier,
    icon: ImageVector,
    title: String,
    subtitle: String,
    onClick: () -> Unit
) {

    Card(
        modifier = modifier
            .height(150.dp)
            .clickable {
                onClick()
            },
        shape = RoundedCornerShape(22.dp),
        colors = CardDefaults.cardColors(
            containerColor =
                MaterialTheme.colorScheme.surfaceContainer
        )
    ) {

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(18.dp),
            verticalArrangement = Arrangement.SpaceBetween
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


            // =====================================
            // ACTION NAME
            // =====================================

            Column {

                Text(
                    text = title,
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.Bold
                )

                Text(
                    text = subtitle,
                    style = MaterialTheme.typography.bodyMedium,
                    color =
                        MaterialTheme.colorScheme.onSurfaceVariant
                )
            }
        }
    }
}