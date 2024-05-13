package com.example.myapplication.ui.theme

import android.content.Context
import android.widget.Toast
import androidx.biometric.BiometricManager.Authenticators.BIOMETRIC_STRONG
import androidx.biometric.BiometricManager.Authenticators.DEVICE_CREDENTIAL
import androidx.biometric.BiometricPrompt
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.platform.LocalContext
import androidx.core.content.ContextCompat
import androidx.fragment.app.FragmentActivity
import kotlinx.coroutines.delay

@Composable
fun Greeting(name: String) {
    val context = LocalContext.current
    val activity = LocalContext.current as FragmentActivity
    val executor = ContextCompat.getMainExecutor(activity)


    var promptInfo = BiometricPrompt.PromptInfo.Builder()
        .setTitle("title")
        .setSubtitle("subtitle")
        .setAllowedAuthenticators(BIOMETRIC_STRONG or DEVICE_CREDENTIAL)
        .build()

    val biometricPrompt = BiometricPrompt(activity, executor,
        object: BiometricPrompt.AuthenticationCallback(){
            override fun onAuthenticationError(errorCode: Int, errString: CharSequence) {
                super.onAuthenticationError(errorCode, errString)
                Toast.makeText(
                    context,
                    "error",
                    Toast.LENGTH_SHORT
                ).show()
            }

            override fun onAuthenticationSucceeded(result: BiometricPrompt.AuthenticationResult) {
                super.onAuthenticationSucceeded(result)
                Toast.makeText(context, "succeeded!", Toast.LENGTH_LONG).show()
            }

            override fun onAuthenticationFailed() {
                super.onAuthenticationFailed()
                Toast.makeText(
                    context, "failed", Toast.LENGTH_LONG
                ).show()
            }
        }
    )

    LaunchedEffect(Unit){
        delay(500)
        biometricPrompt.authenticate(promptInfo)
    }

    Text(text = "hello, $name!")


}
