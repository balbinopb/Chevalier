package com.example.tugas4.screens

import android.widget.Toast
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.*
import androidx.compose.ui.*
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.*
import com.example.tugas4.RegisterViewModel
import com.example.tugas4.components.*
import com.example.tugas4.ui.theme.*



@Composable
fun RegisterPage(modifier: Modifier = Modifier,viewModel: RegisterViewModel) {

    val context = LocalContext.current

    val username by viewModel.username.collectAsState()
    val email by viewModel.email.collectAsState()
    val password by viewModel.password.collectAsState()

    Surface {
        Column(
            modifier = Modifier.fillMaxSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp, Alignment.CenterVertically),
            horizontalAlignment = Alignment.Start
        ) {
            Text(
                text = "Register",
                fontSize = 24.sp
            )
            Text(
                text = "Daftar menggunakan username, email dan password anda.",
            )
            textField(
                modifier = Modifier.fillMaxWidth(),
                label = "Username",
                hint = "Buat username",
                value = username,
                onValueChange = { newUsername ->
                    //username = newUsername
                    viewModel.updateUsername(newUsername)
                },
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Default.Person,
                        contentDescription = "Username"
                    )
                }
            )
            textField(
                modifier = Modifier.fillMaxWidth(),
                label = "Email",
                hint = "Masukkan Email",
                value = email,
                onValueChange = { newEmail ->
                    //email = text
                    viewModel.updateEmail(newEmail)
                },
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Default.Email,
                        contentDescription = "Email"
                    )
                }
            )
            passwordField(
                modifier = Modifier.fillMaxWidth(),
                label = "Password",
                hint = "Buat Password",
                value = password,
                onValueChange = { newPassword ->
                    //password = text
                    viewModel.updatePassword(newPassword)
                },
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Default.Lock,
                        contentDescription = "Password"
                    )
                },
                viewModel = RegisterViewModel()

            )
            Button(
                modifier = Modifier.fillMaxWidth(),
                onClick = {
                    when {
                        username.isEmpty() || email.isEmpty() || password.isEmpty() -> {
                            Toast.makeText(context, "All fields are required", Toast.LENGTH_SHORT).show()
                        }
                        else -> {
                            Toast.makeText(context, "Registration Successful", Toast.LENGTH_SHORT).show()
                        }
                    }
                },
                colors = ButtonDefaults.buttonColors(
                    containerColor = Pink50,
                    //contentColor = MaterialTheme.colorScheme.onPrimary
                )
            ) {
                Text(text = "Register")
            }
        }
    }
}