package com.example.roastem

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.example.roastem.ui.theme.RoastemTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RoastemTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color =MaterialTheme.colorScheme.background) {
                }
                RecipeScreen()
            }
        }
    }
}
