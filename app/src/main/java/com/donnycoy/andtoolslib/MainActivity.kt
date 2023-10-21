package com.donnycoy.andtoolslib

import android.os.Bundle
import android.os.Message
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
import com.donnycoy.andtoolslib.ui.theme.AndToolsLibTheme
import com.donnycoy.mylibrary.density.DensityUtils
import com.donnycoy.mylibrary.handler.WeakHandler

class MainActivity : ComponentActivity() {
    companion object {
        private val TAG = MainActivity::class.java.simpleName
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AndToolsLibTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Greeting("Android")
                }
            }
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
    AndToolsLibTheme {
        Greeting("Android")
    }
}

class MyHandler(host : MainActivity) : WeakHandler<MainActivity>(host) {
    override fun handleMessageWhenServive(msg: Message, host: MainActivity) {
        when(msg.what) {
            0 -> {
                Log.d("WeakHandler", "handleMessageWhenServive: ${DensityUtils.convertSpToPixel(host.applicationContext, 22f)}")
            }
        }
    }

    override fun handleMessageWhenNotServive(msg: Message) {
        super.handleMessageWhenNotServive(msg)
    }
}