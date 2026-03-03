package xyz.teamgravity.m3expressivemotion

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import xyz.teamgravity.m3expressivemotion.ui.theme.M3ExpressiveMotionTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            M3ExpressiveMotionTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { padding ->
                }
            }
        }
    }
}