package com.example.ufa

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.ufa.ui.theme.UfaTheme

class RegisterActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            UfaTheme {
                RegisterScreen(
                    onBackClick = { finish() },
                    onRegisterClick = {
                        startActivity(Intent(this, MainActivity::class.java))
                        finish()
                    },
                    onLoginClick = { finish() }
                )
            }
        }
    }
}