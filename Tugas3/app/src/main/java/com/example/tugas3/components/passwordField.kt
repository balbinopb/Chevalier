package com.example.tugas3.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
//import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.*
import androidx.compose.ui.unit.dp


@Composable
fun passwordField(
    modifier: Modifier = Modifier,
    label: String,
    hint: String,
    value: String,
    onValueChange: (String) -> Unit,
    leadingIcon: @Composable () -> Unit
) {
    var passwordVisible by remember { mutableStateOf(false) }

    Column(
        modifier = modifier//.padding(vertical = 8.dp)
    ) {
        Text(
            text = label,
            style = MaterialTheme.typography.labelLarge
        )
        OutlinedTextField(
            modifier = Modifier.fillMaxWidth(),
            //label = { Text(label) },
            value = value,
            onValueChange = onValueChange,
            placeholder = { Text(hint) },
            leadingIcon = leadingIcon,
            trailingIcon = {
                val image = if (passwordVisible) Icons.Filled.Visibility else Icons.Filled.VisibilityOff
                IconButton(onClick = { passwordVisible = !passwordVisible }) {
                    Icon(imageVector = image, contentDescription = "Toggle Password Visibility")
                }
            },
            visualTransformation = if (passwordVisible) VisualTransformation.None else PasswordVisualTransformation(),
            keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Password),
            singleLine = true,

        )
    }
}

