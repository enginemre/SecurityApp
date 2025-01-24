package com.engin.securityapp.ui.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.datastore.dataStore
import com.engin.securityapp.datastore.UserPreferences
import com.engin.securityapp.datastore.userDataStore
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch

const val encryptionScreenRoute = "encryptionScreen"
const val exampleData = "Test"

@Composable
fun DataStoreEncryptionScreen() {
    val scope = rememberCoroutineScope()
    val context = LocalContext.current
    Scaffold(
        contentWindowInsets = WindowInsets(0, 0, 0, 0)
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(32.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            var text by remember {
                mutableStateOf("")
            }
            Button(
                onClick = {
                    scope.launch {
                        context.userDataStore.updateData {
                            UserPreferences(
                                secretData = exampleData
                            )
                        }
                    }

                }
            ) {
                Text("Encrypt Data")
            }
            Button(
                onClick = {
                    scope.launch {
                        text = context.userDataStore.data.first().secretData.orEmpty()
                    }

                }
            ) {
                Text("Decrypt Data")
            }
            Spacer(Modifier.height(12.dp))
            Text(
                text = text
            )
        }
    }
}