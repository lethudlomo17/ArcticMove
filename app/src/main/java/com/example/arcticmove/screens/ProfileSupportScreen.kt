package com.example.arcticmove.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowRight
import androidx.compose.material.icons.automirrored.filled.Logout
import androidx.compose.material.icons.filled.Description
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Help
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material.icons.filled.SupportAgent
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.arcticmove.data.UserRepository


@Composable
fun ProfileSupportScreen(
    onLogoutClick: () -> Unit,
    onBackClick: () -> Unit
) {

    // =========================================
    // GET THE CURRENT LOGGED-IN USER
    // =========================================

    val currentUser = UserRepository.getCurrentUser()


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
                    text = "Profile & Support",
                    style = MaterialTheme.typography.headlineSmall,
                    fontWeight = FontWeight.Bold
                )

                Text(
                    text = "Account and help centre",
                    style = MaterialTheme.typography.bodyMedium,
                    color =
                        MaterialTheme.colorScheme.onSurfaceVariant
                )
            }
        }


        Spacer(
            modifier = Modifier.height(32.dp)
        )


        // =========================================
        // CHECK IF USER IS LOGGED IN
        // =========================================

        if (currentUser != null) {

            // =====================================
            // PROFILE HEADER
            // =====================================

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
                        .padding(24.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {

                    // =================================
                    // PROFILE ICON
                    // =================================

                    Surface(
                        modifier = Modifier.size(92.dp),
                        shape = CircleShape,
                        color = MaterialTheme.colorScheme.primary
                    ) {

                        Box(
                            modifier = Modifier.fillMaxSize(),
                            contentAlignment = Alignment.Center
                        ) {

                            Icon(
                                imageVector = Icons.Default.Person,
                                contentDescription = "Profile",
                                tint = MaterialTheme.colorScheme.onPrimary,
                                modifier = Modifier.size(48.dp)
                            )
                        }
                    }


                    Spacer(
                        modifier = Modifier.height(16.dp)
                    )


                    // =================================
                    // REAL USER NAME
                    // =================================

                    Text(
                        text = currentUser.fullName,
                        style = MaterialTheme.typography.headlineSmall,
                        fontWeight = FontWeight.Bold,
                        textAlign = TextAlign.Center
                    )


                    Spacer(
                        modifier = Modifier.height(4.dp)
                    )


                    Text(
                        text = "Arctic Move Customer",
                        style = MaterialTheme.typography.bodyMedium,
                        color =
                            MaterialTheme.colorScheme.onPrimaryContainer
                    )
                }
            }


            Spacer(
                modifier = Modifier.height(30.dp)
            )


            // =====================================
            // PERSONAL INFORMATION
            // =====================================

            SectionTitle(
                text = "PERSONAL INFORMATION"
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

                    // =================================
                    // NAME
                    // =================================

                    ProfileInformationRow(
                        icon = Icons.Default.Person,
                        label = "Full Name",
                        value = currentUser.fullName
                    )


                    HorizontalDivider(
                        modifier = Modifier.padding(
                            vertical = 14.dp
                        )
                    )


                    // =================================
                    // EMAIL
                    // =================================

                    ProfileInformationRow(
                        icon = Icons.Default.Email,
                        label = "Email Address",
                        value = currentUser.email
                    )


                    HorizontalDivider(
                        modifier = Modifier.padding(
                            vertical = 14.dp
                        )
                    )


                    // =================================
                    // PHONE
                    // =================================

                    ProfileInformationRow(
                        icon = Icons.Default.Phone,
                        label = "Phone Number",
                        value = currentUser.phoneNumber
                    )
                }
            }

        } else {

            // =====================================
            // NO LOGGED-IN USER
            // =====================================

            Card(
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(24.dp),
                colors = CardDefaults.cardColors(
                    containerColor =
                        MaterialTheme.colorScheme.surfaceContainer
                )
            ) {

                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(30.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {

                    Surface(
                        modifier = Modifier.size(72.dp),
                        shape = CircleShape,
                        color =
                            MaterialTheme.colorScheme.secondaryContainer
                    ) {

                        Box(
                            modifier = Modifier.fillMaxSize(),
                            contentAlignment = Alignment.Center
                        ) {

                            Icon(
                                imageVector = Icons.Default.Person,
                                contentDescription = null,
                                tint =
                                    MaterialTheme.colorScheme
                                        .onSecondaryContainer,
                                modifier = Modifier.size(36.dp)
                            )
                        }
                    }


                    Spacer(
                        modifier = Modifier.height(18.dp)
                    )


                    Text(
                        text = "User information unavailable",
                        style = MaterialTheme.typography.titleMedium,
                        fontWeight = FontWeight.Bold
                    )


                    Spacer(
                        modifier = Modifier.height(6.dp)
                    )


                    Text(
                        text = "Please log in again to view your profile information.",
                        style = MaterialTheme.typography.bodyMedium,
                        color =
                            MaterialTheme.colorScheme.onSurfaceVariant,
                        textAlign = TextAlign.Center
                    )
                }
            }
        }


        Spacer(
            modifier = Modifier.height(30.dp)
        )


        // =========================================
        // HELP & SUPPORT
        // =========================================

        SectionTitle(
            text = "HELP & SUPPORT"
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

            Column {

                // =================================
                // HELP & FAQ
                // =================================

                SupportOption(
                    icon = Icons.Default.Help,
                    title = "Help & FAQ",
                    subtitle = "Find answers to common questions",
                    onClick = {
                        // Connect later
                    }
                )


                HorizontalDivider(
                    modifier = Modifier.padding(
                        horizontal = 18.dp
                    )
                )


                // =================================
                // CONTACT SUPPORT
                // =================================

                SupportOption(
                    icon = Icons.Default.SupportAgent,
                    title = "Contact Support",
                    subtitle = "Get help from the Arctic Move team",
                    onClick = {
                        // Connect later
                    }
                )


                HorizontalDivider(
                    modifier = Modifier.padding(
                        horizontal = 18.dp
                    )
                )


                // =================================
                // TERMS & CONDITIONS
                // =================================

                SupportOption(
                    icon = Icons.Default.Description,
                    title = "Terms & Conditions",
                    subtitle = "Read our terms of service",
                    onClick = {
                        // Connect later
                    }
                )
            }
        }


        Spacer(
            modifier = Modifier.height(30.dp)
        )


        // =========================================
        // ACCOUNT
        // =========================================

        SectionTitle(
            text = "ACCOUNT"
        )


        Spacer(
            modifier = Modifier.height(12.dp)
        )


        // =========================================
        // LOG OUT
        // =========================================

        OutlinedButton(
            onClick = {

                // Remove the logged-in user session
                UserRepository.logoutUser()

                // Run your existing navigation logout
                onLogoutClick()
            },
            modifier = Modifier
                .fillMaxWidth()
                .height(58.dp),
            shape = RoundedCornerShape(16.dp)
        ) {

            Icon(
                imageVector =
                    Icons.AutoMirrored.Filled.Logout,
                contentDescription = null
            )


            Spacer(
                modifier = Modifier.width(10.dp)
            )


            Text(
                text = "Log Out",
                fontWeight = FontWeight.Bold
            )
        }


        Spacer(
            modifier = Modifier.height(12.dp)
        )


        // =========================================
        // BACK TO HOME
        // =========================================

        Button(
            onClick = {
                onBackClick()
            },
            modifier = Modifier
                .fillMaxWidth()
                .height(58.dp),
            shape = RoundedCornerShape(16.dp)
        ) {

            Icon(
                imageVector =
                    Icons.AutoMirrored.Filled.ArrowBack,
                contentDescription = null
            )


            Spacer(
                modifier = Modifier.width(10.dp)
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
            style = MaterialTheme.typography.bodySmall,
            color =
                MaterialTheme.colorScheme.onSurfaceVariant,
            textAlign = TextAlign.Center,
            modifier = Modifier.fillMaxWidth()
        )


        Spacer(
            modifier = Modifier.height(24.dp)
        )
    }
}


// =============================================
// PROFILE INFORMATION ROW
// =============================================

@Composable
private fun ProfileInformationRow(
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
                modifier = Modifier.height(3.dp)
            )


            Text(
                text = value,
                style = MaterialTheme.typography.bodyLarge,
                fontWeight = FontWeight.SemiBold
            )
        }
    }
}


// =============================================
// SUPPORT OPTION
// =============================================

@Composable
private fun SupportOption(
    icon: ImageVector,
    title: String,
    subtitle: String,
    onClick: () -> Unit
) {

    TextButton(
        onClick = {
            onClick()
        },
        modifier = Modifier
            .fillMaxWidth()
            .padding(
                horizontal = 6.dp,
                vertical = 4.dp
            ),
        contentPadding = PaddingValues(
            horizontal = 12.dp,
            vertical = 14.dp
        )
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
            modifier = Modifier.weight(1f),
            horizontalAlignment = Alignment.Start
        ) {

            Text(
                text = title,
                style = MaterialTheme.typography.titleSmall,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.onSurface
            )


            Spacer(
                modifier = Modifier.height(2.dp)
            )


            Text(
                text = subtitle,
                style = MaterialTheme.typography.bodySmall,
                color =
                    MaterialTheme.colorScheme.onSurfaceVariant
            )
        }


        Spacer(
            modifier = Modifier.width(8.dp)
        )


        Icon(
            imageVector =
                Icons.AutoMirrored.Filled.KeyboardArrowRight,
            contentDescription = null,
            tint =
                MaterialTheme.colorScheme.onSurfaceVariant
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