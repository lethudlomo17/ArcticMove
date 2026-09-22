package com.example.arcticmove.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.arcticmove.R
import com.example.arcticmove.data.UserRepository
import kotlinx.coroutines.launch


@Composable
fun LoginScreen(
    onRegisterClick: () -> Unit,
    onLoginSuccess: () -> Unit
) {

    // =========================================
    // LOGIN STATE
    // =========================================

    var email by remember {
        mutableStateOf("")
    }

    var password by remember {
        mutableStateOf("")
    }

    var passwordVisible by remember {
        mutableStateOf(false)
    }

    var errorMessage by remember {
        mutableStateOf("")
    }

    var isLoading by remember {
        mutableStateOf(false)
    }

    val coroutineScope = rememberCoroutineScope()


    // =========================================
    // SCREEN BACKGROUND
    // =========================================

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                Brush.verticalGradient(
                    colors = listOf(
                        MaterialTheme.colorScheme.primaryContainer,
                        MaterialTheme.colorScheme.surface,
                        MaterialTheme.colorScheme.surface
                    )
                )
            )
    ) {

        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(
                    rememberScrollState()
                )
                .padding(
                    horizontal = 22.dp
                ),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {


            Spacer(
                modifier = Modifier.height(50.dp)
            )


            // =========================================
            // LOGO CONTAINER
            // =========================================

            Surface(
                modifier = Modifier.size(112.dp),
                shape = CircleShape,
                color = MaterialTheme.colorScheme.surface,
                shadowElevation = 10.dp
            ) {

                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(16.dp),
                    contentAlignment = Alignment.Center
                ) {

                    Image(
                        painter = painterResource(
                            id = R.drawable.arctic_move_logo
                        ),
                        contentDescription = "Arctic Move Logo",
                        modifier = Modifier
                            .fillMaxSize()
                            .clip(CircleShape)
                    )
                }
            }


            Spacer(
                modifier = Modifier.height(18.dp)
            )


            // =========================================
            // BRAND NAME
            // =========================================

            Text(
                text = "ARCTIC MOVE",
                style = MaterialTheme.typography.headlineMedium,
                fontWeight = FontWeight.ExtraBold,
                letterSpacing = 2.sp,
                color = MaterialTheme.colorScheme.primary
            )


            Spacer(
                modifier = Modifier.height(6.dp)
            )


            Text(
                text = "Move it. Track it. Delivered.",
                style = MaterialTheme.typography.bodyLarge,
                color = MaterialTheme.colorScheme.onSurfaceVariant,
                textAlign = TextAlign.Center
            )


            Spacer(
                modifier = Modifier.height(30.dp)
            )


            // =========================================
            // LOGIN CARD
            // =========================================

            Card(
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(28.dp),
                colors = CardDefaults.cardColors(
                    containerColor =
                        MaterialTheme.colorScheme.surface
                ),
                elevation = CardDefaults.cardElevation(
                    defaultElevation = 8.dp
                )
            ) {

                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(24.dp)
                ) {


                    // =================================
                    // WELCOME TEXT
                    // =================================

                    Text(
                        text = "Welcome back 👋",
                        style = MaterialTheme.typography.headlineSmall,
                        fontWeight = FontWeight.Bold
                    )


                    Spacer(
                        modifier = Modifier.height(6.dp)
                    )


                    Text(
                        text = "Sign in to continue your deliveries.",
                        style = MaterialTheme.typography.bodyMedium,
                        color =
                            MaterialTheme.colorScheme.onSurfaceVariant
                    )


                    Spacer(
                        modifier = Modifier.height(26.dp)
                    )


                    // =================================
                    // EMAIL
                    // =================================

                    OutlinedTextField(
                        value = email,
                        onValueChange = {

                            email = it

                            if (errorMessage.isNotEmpty()) {
                                errorMessage = ""
                            }
                        },
                        label = {
                            Text("Email address")
                        },
                        placeholder = {
                            Text("name@example.com")
                        },
                        leadingIcon = {

                            Icon(
                                imageVector = Icons.Default.Email,
                                contentDescription = null
                            )
                        },
                        singleLine = true,
                        enabled = !isLoading,
                        keyboardOptions = KeyboardOptions(
                            keyboardType = KeyboardType.Email,
                            imeAction = ImeAction.Next
                        ),
                        shape = RoundedCornerShape(16.dp),
                        modifier = Modifier.fillMaxWidth()
                    )


                    Spacer(
                        modifier = Modifier.height(16.dp)
                    )


                    // =================================
                    // PASSWORD
                    // =================================

                    OutlinedTextField(
                        value = password,
                        onValueChange = {

                            password = it

                            if (errorMessage.isNotEmpty()) {
                                errorMessage = ""
                            }
                        },
                        label = {
                            Text("Password")
                        },
                        placeholder = {
                            Text("Enter your password")
                        },
                        leadingIcon = {

                            Icon(
                                imageVector = Icons.Default.Lock,
                                contentDescription = null
                            )
                        },
                        trailingIcon = {

                            IconButton(
                                onClick = {
                                    passwordVisible =
                                        !passwordVisible
                                }
                            ) {

                                Icon(
                                    imageVector =
                                        if (passwordVisible) {
                                            Icons.Default.VisibilityOff
                                        } else {
                                            Icons.Default.Visibility
                                        },
                                    contentDescription =
                                        if (passwordVisible) {
                                            "Hide password"
                                        } else {
                                            "Show password"
                                        }
                                )
                            }
                        },
                        visualTransformation =
                            if (passwordVisible) {
                                VisualTransformation.None
                            } else {
                                PasswordVisualTransformation()
                            },
                        singleLine = true,
                        enabled = !isLoading,
                        keyboardOptions = KeyboardOptions(
                            keyboardType =
                                KeyboardType.Password,
                            imeAction =
                                ImeAction.Done
                        ),
                        shape = RoundedCornerShape(16.dp),
                        modifier = Modifier.fillMaxWidth()
                    )


                    // =================================
                    // ERROR MESSAGE
                    // =================================

                    if (errorMessage.isNotEmpty()) {

                        Spacer(
                            modifier = Modifier.height(14.dp)
                        )

                        Surface(
                            modifier = Modifier.fillMaxWidth(),
                            shape = RoundedCornerShape(12.dp),
                            color =
                                MaterialTheme.colorScheme.errorContainer
                        ) {

                            Text(
                                text = errorMessage,
                                color =
                                    MaterialTheme.colorScheme.onErrorContainer,
                                style =
                                    MaterialTheme.typography.bodyMedium,
                                modifier =
                                    Modifier.padding(12.dp)
                            )
                        }
                    }


                    Spacer(
                        modifier = Modifier.height(24.dp)
                    )


                    // =================================
                    // LOGIN BUTTON
                    // =================================

                    Button(
                        onClick = {

                            when {

                                email.isBlank() -> {

                                    errorMessage =
                                        "Please enter your email address."
                                }


                                !email.contains("@") -> {

                                    errorMessage =
                                        "Please enter a valid email address."
                                }


                                password.isBlank() -> {

                                    errorMessage =
                                        "Please enter your password."
                                }


                                else -> {

                                    coroutineScope.launch {

                                        isLoading = true
                                        errorMessage = ""

                                        try {

                                            val loginSuccessful =
                                                UserRepository.loginUser(
                                                    email =
                                                        email.trim(),
                                                    password =
                                                        password
                                                )

                                            if (loginSuccessful) {

                                                isLoading = false

                                                onLoginSuccess()

                                            } else {

                                                isLoading = false

                                                errorMessage =
                                                    "Incorrect email or password."
                                            }

                                        } catch (
                                            exception: Exception
                                        ) {

                                            isLoading = false

                                            errorMessage =
                                                "Unable to login. Please try again."
                                        }
                                    }
                                }
                            }
                        },
                        enabled = !isLoading,
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(58.dp),
                        shape = RoundedCornerShape(17.dp)
                    ) {

                        if (isLoading) {

                            CircularProgressIndicator(
                                modifier =
                                    Modifier.size(22.dp),
                                strokeWidth = 2.dp,
                                color =
                                    MaterialTheme.colorScheme.onPrimary
                            )


                            Spacer(
                                modifier =
                                    Modifier.width(10.dp)
                            )


                            Text(
                                text = "Signing in...",
                                fontWeight = FontWeight.Bold
                            )

                        } else {

                            Text(
                                text = "SIGN IN",
                                fontWeight = FontWeight.Bold,
                                letterSpacing = 1.sp
                            )
                        }
                    }
                }
            }


            Spacer(
                modifier = Modifier.height(24.dp)
            )


            // =========================================
            // REGISTER SECTION
            // =========================================

            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center,
                modifier = Modifier.fillMaxWidth()
            ) {

                HorizontalDivider(
                    modifier = Modifier.weight(1f)
                )


                Text(
                    text = "  New here?  ",
                    style = MaterialTheme.typography.bodySmall,
                    color =
                        MaterialTheme.colorScheme.onSurfaceVariant
                )


                HorizontalDivider(
                    modifier = Modifier.weight(1f)
                )
            }


            Spacer(
                modifier = Modifier.height(12.dp)
            )


            OutlinedButton(
                onClick = {
                    onRegisterClick()
                },
                enabled = !isLoading,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(54.dp),
                shape = RoundedCornerShape(16.dp)
            ) {

                Text(
                    text = "CREATE AN ACCOUNT",
                    fontWeight = FontWeight.Bold,
                    letterSpacing = 0.5.sp
                )
            }


            Spacer(
                modifier = Modifier.height(18.dp)
            )


            // =========================================
            // SECURITY MESSAGE
            // =========================================

            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center,
                modifier = Modifier.fillMaxWidth()
            ) {

                Icon(
                    imageVector = Icons.Default.Lock,
                    contentDescription = null,
                    modifier = Modifier.size(15.dp),
                    tint =
                        MaterialTheme.colorScheme.onSurfaceVariant
                )


                Spacer(
                    modifier = Modifier.width(6.dp)
                )


                Text(
                    text = "Secure access to your Arctic Move account",
                    style = MaterialTheme.typography.bodySmall,
                    color =
                        MaterialTheme.colorScheme.onSurfaceVariant
                )
            }


            Spacer(
                modifier = Modifier.height(32.dp)
            )
        }
    }
}