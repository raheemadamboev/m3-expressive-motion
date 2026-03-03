package xyz.teamgravity.m3expressivemotion

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.unit.dp
import xyz.teamgravity.m3expressivemotion.ui.theme.M3ExpressiveMotionTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            M3ExpressiveMotionTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { padding ->
                    Box(
                        contentAlignment = Alignment.Center,
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(padding)
                    ) {
                        var scaledDown by remember { mutableStateOf(true) }
                        val scaleProgress by animateFloatAsState(
                            targetValue = if (scaledDown) 0F else 1F,
                            animationSpec = MaterialTheme.motionScheme.fastSpatialSpec()
                        )

                        Box(
                            modifier = Modifier
                                .size(100.dp)
                                .graphicsLayer {
                                    scaleX = 1F + scaleProgress
                                    scaleY = 1F + scaleProgress
                                }
                                .background(Color.Red)
                                .clickable(
                                    role = Role.Button,
                                    onClick = {
                                        scaledDown = !scaledDown
                                    }
                                )
                        )
                    }
                }
            }
        }
    }
}