package com.example.clicer

import android.media.MediaPlayer
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.draw.shadow
import androidx.compose.foundation.shape.CircleShape
import com.example.clicer.ui.theme.ClicerTheme
import androidx.compose.ui.Alignment
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.text.font.FontFamily

class MainActivity : ComponentActivity() {
    private var mediaPlayer: MediaPlayer? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ClicerTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    ClickableCircle(
                        modifier = Modifier.padding(innerPadding),
                        onClick = {
                            playSound()
                        }
                    )
                }
            }
        }
    }

    private fun playSound() {
        mediaPlayer = MediaPlayer.create(this, R.raw.clicker) // Ensure the resource ID is correct
        mediaPlayer?.start()
    }

    override fun onDestroy() {
        super.onDestroy()
        mediaPlayer?.release()
        mediaPlayer = null
    }
}

@Composable
fun ClickableCircle(modifier: Modifier = Modifier, onClick: () -> Unit) {
    Box(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp), // Add padding around the circle
        contentAlignment = Alignment.Center // Center the circle
    ) {
        Box(
            modifier = Modifier
                .size(300.dp)
                .background(
                    brush = Brush.linearGradient(
                        colors = listOf(Color(0xFF4CAF50), Color(0xFF388E3C)), // Gradient from light to dark green
                        start = Offset(0f, 0f),
                        end = Offset(300f, 300f)
                    ),
                    shape = CircleShape
                ) // Circle background with gradient
                .border(
                    BorderStroke(4.dp, Brush.linearGradient(
                        colors = listOf(Color.White, Color.LightGray),
                        start = Offset(0f, 0f),
                        end = Offset(300f, 300f)
                    )),
                    shape = CircleShape
                ) // A more pronounced border with a subtle gradient
                .shadow(12.dp, CircleShape, ambientColor = Color.Black.copy(alpha = 0.2f), spotColor = Color.Black) // Enhanced shadow for a 3D effect
                .clickable(onClick = onClick), // Make the circle clickable
            contentAlignment = Alignment.Center // Center the text inside the box
        ) {
            Text(
                text = "Smokey & Lolo",
                color = Color.White,
                style = TextStyle(
                    fontSize = 24.sp, // Slightly larger font size for emphasis
                    fontWeight = FontWeight.Bold,
                    letterSpacing = 1.75.sp, // Slightly increased letter spacing for readability
                    fontFamily = FontFamily.Serif // Use a professional font like Serif
                ),
                modifier = Modifier.padding(16.dp) // Add some padding around the text
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewClickableCircle() {
    ClicerTheme {
        ClickableCircle(onClick = {})
    }
}