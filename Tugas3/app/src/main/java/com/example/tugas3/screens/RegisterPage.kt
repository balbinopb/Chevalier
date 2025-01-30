package com.example.tugas3.screens

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
//import androidx.compose.ui.unit.sp
import com.example.tugas3.components.*
//import com.example.tugas3.components.textField
import com.example.tugas3.ui.theme.*



@Composable
fun RegisterPage(modifier: Modifier = Modifier) {

    val context = LocalContext.current

    var username by remember { mutableStateOf("") } //to store username
    var email by remember { mutableStateOf("") } //to store email
    var password by remember { mutableStateOf("") } //to store pw

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
                onValueChange = { text ->
                    username = text
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
                onValueChange = { text ->
                    email = text
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
                onValueChange = { text ->
                    password = text
                },
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Default.Lock,
                        contentDescription = "Password"
                    )
                }
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