package com.apadmi.tomrh.redirectdemo

import android.net.Uri
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.browser.customtabs.CustomTabsIntent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import com.apadmi.tomrh.redirectdemo.ui.MainViewModel
import com.apadmi.tomrh.redirectdemo.ui.theme.RedirectDemoTheme
import androidx.lifecycle.viewmodel.compose.viewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            RedirectDemoTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Demo(
                        onLaunchUrl = ::launchBrowser,
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }

    private fun launchBrowser() {
        val url = Uri.parse("http://localhost:8080/local-mock/dummy-page")
        val intent = CustomTabsIntent.Builder().build()
        intent.launchUrl(this, url)
    }
}

@Composable
fun Demo(viewModel: MainViewModel = viewModel(), onLaunchUrl: () -> Unit, modifier: Modifier,) {
    val state by viewModel.state.collectAsState()
    Column(modifier) {
        Text("You have pressed the button $state times")
        FilledTonalButton(
            onClick = {
                viewModel.incrementCounter()
            }
        ) {
            Text("Increment count")
        }
        FilledTonalButton(
            onClick = onLaunchUrl
        ) {
            Text("Open browser")
        }
    }
}