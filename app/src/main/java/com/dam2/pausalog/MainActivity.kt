package com.dam2.pausalog

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.dam2.pausalog.ui.theme.PausaLogTheme
import kotlin.time.Duration
import kotlin.time.Duration.Companion.seconds

class MainActivity : ComponentActivity() {
    val TAG : String = "Estado"
    var startTime: Long = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            startTime = System.currentTimeMillis()
            PausaLogTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Greeting("Android")
                }
            }
        }
        fun onStart() {
            super.onStart()
            Log.d(TAG,"He llegado al start")
        }

        fun onResume() {
            super.onResume()
            Log.d(TAG, "He llegado al resume")
        }

        fun onPause() {
            super.onPause()
            Log.d(TAG,"He llegado al pause")
        }

        fun onStop() {
            super.onStop()
            Log.d(TAG, "Duro")
        }

        fun onRestart() {
            super.onRestart()
            Log.d(TAG, "He llegado al restart")
        }

        fun onDestroy() {
            super.onDestroy()
            val endTime = System.currentTimeMillis()
            val totalTime = endTime - startTime
            Log.d("AppTiming", "App startup and shutdown time: $totalTime milliseconds")
            Log.e(TAG, "He llegado al destroy")
        }
    }
    }

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    PausaLogTheme {
        Greeting("Android")
    }
}