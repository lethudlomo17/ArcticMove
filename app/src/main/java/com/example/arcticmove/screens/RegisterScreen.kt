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
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
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
import com.example.arcticmove.data.User
import com.example.arcticmove.data.UserRepository
import kotlinx.coroutines.launch


@Composable
fun RegisterScreen(
    onLoginClick: () -> Unit
) {

    // =========================================
    // REGISTER STATE
    // =========================================

    var fullName by remember {
        mutableStateOf("")
    }

    var email by remember {
        mutableStateOf("")
    }

    var phoneNumber by remember {
        mutableStateOf("")
    }

    var password by remember {
        mutableStateOf("")
    }

    var confirmPassword by remember {
        mutableStateOf("")
    }

    var passwordVisible by remember {
        mutableStateOf(false)
    }

    var confirmPasswordVisible by remember {
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
    // BACKGROUND
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
                modifier = Modifier.height(34.dp)
            )


            // =========================================
            // LOGO
            // =========================================

            Surface(
                modifier = Modifier.size(88.dp),
                shape = CircleShape,
                color = MaterialTheme.colorScheme.surface,
                shadowElevation = 8.dp
            ) {

                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(13.dp),
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
                modifier = Modifier.height(14.dp)
            )


            // =========================================
            // BRAND
            // =========================================

            Text(
                text = "ARCTIC MOVE",
                style = MaterialTheme.typography.titleLarge,
                fontWeight = FontWeight.ExtraBold,
                letterSpacing = 2.sp,
                color = MaterialTheme.colorScheme.primary
            )


            Spacer(
                modifier = Modifier.height(5.dp)
            )


            Text(
                text = "Deliver smarter. Move faster.",
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onSurfaceVariant,
                textAlign = TextAlign.Center
            )


            Spacer(
                modifier = Modifier.height(22.dp)
            )


            // =========================================
            // REGISTRATION CARD
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
                        .padding(22.dp)
                ) {


                    // =================================
                    // HEADER
                    // =================================

                    Text(
                        text = "Create your account 🚀",
                        style = MaterialTheme.typography.headlineSmall,
                        fontWeight = FontWeight.Bold
                    )


                    Spacer(
                        modifier = Modifier.height(5.dp)
                    )


                    Text(
                        text = "Join Arctic Move and start delivering.",
                        style = MaterialTheme.typography.bodyMedium,
                        color =
                            MaterialTheme.colorScheme.onSurfaceVariant
                    )


                    Spacer(
                        modifier = Modifier.height(22.dp)
                    )


                    // =================================
                    // FULL NAME
                    // =================================

                    OutlinedTextField(
                        value = fullName,
                        onValueChange = {

                            fullName = it

                            if (errorMessage.isNotEmpty()) {
                                errorMessage = ""
                            }
                        },
                        label = {
                            Text("Full name")
                        },
                        placeholder = {
                            Text("Enter your full name")
                        },
                        leadingIcon = {

                            Icon(
                                imageVector = Icons.Default.Person,
                                contentDescription = null
                            )
                        },
                        singleLine = true,
                        enabled = !isLoading,
                        keyboardOptions = KeyboardOptions(
                            keyboardType = KeyboardType.Text,
                            imeAction = ImeAction.Next
                        ),
                        shape = RoundedCornerShape(16.dp),
                        modifier = Modifier.fillMaxWidth()
                    )


                    Spacer(
                        modifier = Modifier.height(13.dp)
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
                        modifier = Modifier.height(13.dp)
                    )


                    // =================================
                    // PHONE NUMBER
                    // =================================

                    OutlinedTextField(
                        value = phoneNumber,
                        onValueChange = {

                            phoneNumber = it

                            if (errorMessage.isNotEmpty()) {
                                errorMessage = ""
                            }
                        },
                        label = {
                            Text("Phone number")
                        },
                        placeholder = {
                            Text("e.g. 071 234 5678")
                        },
                        leadingIcon = {

                            Icon(
                                imageVector = Icons.Default.Phone,
                                contentDescription = null
                            )
                        },
                        singleLine = true,
                        enabled = !isLoading,
                        keyboardOptions = KeyboardOptions(
                            keyboardType = KeyboardType.Phone,
                            imeAction = ImeAction.Next
                        ),
                        shape = RoundedCornerShape(16.dp),
                        modifier = Modifier.fillMaxWidth()
                    )


                    Spacer(
                        modifier = Modifier.height(13.dp)
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
                            Text("Minimum 6 characters")
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
                            keyboardType = KeyboardType.Password,
                            imeAction = ImeAction.Next
                        ),
                        shape = RoundedCornerShape(16.dp),
                        modifier = Modifier.fillMaxWidth()
                    )


                    Spacer(
                        modifier = Modifier.height(13.dp)
                    )


                    // =================================
                    // CONFIRM PASSWORD
                    // =================================

                    OutlinedTextField(
                        value = confirmPassword,
                        onValueChange = {

                            confirmPassword = it

                            if (errorMessage.isNotEmpty()) {
                                errorMessage = ""
                            }
                        },
                        label = {
                            Text("Confirm password")
                        },
                        placeholder = {
                            Text("Re-enter your password")
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

                                    confirmPasswordVisible =
                                        !confirmPasswordVisible
                                }
                            ) {

                                Icon(
                                    imageVector =
                                        if (confirmPasswordVisible) {
                                            Icons.Default.VisibilityOff
                                        } else {
                                            Icons.Default.Visibility
                                        },
                                    contentDescription =
                                        if (confirmPasswordVisible) {
                                            "Hide password"
                                        } else {
                                            "Show password"
                                        }
                                )
                            }
                        },
                        visualTransformation =
                            if (confirmPasswordVisible) {
                                VisualTransformation.None
                            } else {
                                PasswordVisualTransformation()
                            },
                        singleLine = true,
                        enabled = !isLoading,
                        keyboardOptions = KeyboardOptions(
                            keyboardType = KeyboardType.Password,
                            imeAction = ImeAction.Done
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
                        modifier = Modifier.height(22.dp)
                    )


                    // =================================
                    // CREATE ACCOUNT BUTTON
                    // =================================

                    Button(
                        onClick = {

                            when {

                                fullName.isBlank() -> {

                                    errorMessage =
                                        "Please enter your full name."
                                }


                                email.isBlank() -> {

                                    errorMessage =
                                        "Please enter your email address."
                                }


                                !email.contains("@") -> {

                                    errorMessage =
                                        "Please enter a valid email address."
                                }


                                phoneNumber.isBlank() -> {

                                    errorMessage =
                                        "Please enter your phone number."
                                }


                                password.isBlank() -> {

                                    errorMessage =
                                        "Please enter your password."
                                }


                                password.length < 6 -> {

                                    errorMessage =
                                        "Password must contain at least 6 characters."
                                }


                                confirmPassword.isBlank() -> {

                                    errorMessage =
                                        "Please confirm your password."
                                }


                                password != confirmPassword -> {

                                    errorMessage =
                                        "Passwords do not match."
                                }


                                else -> {

                                    coroutineScope.launch {

                                        isLoading = true
                                        errorMessage = ""

                                        try {

                                            // =================================
                                            // CHECK DUPLICATE EMAIL
                                            // =================================

                                            val alreadyExists =
                                                UserRepository.emailExists(
                                                    email.trim()
                                                )


                                            if (alreadyExists) {

                                                errorMessage =
                                                    "An account with this email already exists."

                                                isLoading = false

                                                return@launch
                                            }


                                            // =================================
                                            // CREATE USER
                                            // =================================

                                            val newUser = User(
                                                fullName =
                                                    fullName.trim(),
                                                email =
                                                    email.trim(),
                                                phoneNumber =
                                                    phoneNumber.trim(),
                                                password =
                                                    password
                                            )


                                            // =================================
                                            // SAVE USER TO ROOM
                                            // =================================

                                            UserRepository.registerUser(
                                                newUser
                                            )


                                            isLoading = false


                                            // =================================
                                            // RETURN TO LOGIN
                                            // =================================

                                            onLoginClick()

                                        } catch (
                                            exception: Exception
                                        ) {

                                            isLoading = false

                                            errorMessage =
                                                "Unable to create account. Please try again."
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
                                text = "Creating account...",
                                fontWeight = FontWeight.Bold
                            )

                        } else {

                            Text(
                                text = "CREATE ACCOUNT",
                                fontWeight = FontWeight.Bold,
                                letterSpacing = 0.8.sp
                            )
                        }
                    }

                } // END REGISTRATION CARD COLUMN

            } // END CARD


            Spacer(
                modifier = Modifier.height(22.dp)
            )


            // =========================================
            // LOGIN SECTION
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
                    text = "  Already registered?  ",
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
                    onLoginClick()
                },
                enabled = !isLoading,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(54.dp),
                shape = RoundedCornerShape(16.dp)
            ) {

                Text(
                    text = "BACK TO SIGN IN",
                    fontWeight = FontWeight.Bold,
                    letterSpacing = 0.5.sp
                )
            }


            Spacer(
                modifier = Modifier.height(18.dp)
            )


            // =========================================
            // LOCAL STORAGE FOOTER
            // =========================================

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
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
                    text = "Your account details are stored locally on this device",
                    style = MaterialTheme.typography.bodySmall,
                    color =
                        MaterialTheme.colorScheme.onSurfaceVariant,
                    textAlign = TextAlign.Center
                )
            }


            Spacer(
                modifier = Modifier.height(32.dp)
            )

        } // END MAIN COLUMN

    } // END BACKGROUND BOX

} // END RegisterScreen