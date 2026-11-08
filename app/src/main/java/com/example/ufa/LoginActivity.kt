package com.example.ufa

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.ufa.ui.theme.UfaTheme

class LoginActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            UfaTheme {
                LoginScreen(
                    onLoginClick = {
                        // Explicit intent (Tutorial Four): go to the Home placeholder
                        startActivity(Intent(this, MainActivity::class.java))
                    },
                    onSignUpClick = { /* Register screen comes in Step 3 */ }
                )
            }
        }
    }
}