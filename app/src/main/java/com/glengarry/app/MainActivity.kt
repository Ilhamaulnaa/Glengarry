package com.glengarry.app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.data.user.di.dataUserModule
import com.glengarry.app.navigation.GlengarryNavHost
import com.glengarry.app.ui.theme.GlengarryTheme
import org.koin.android.ext.koin.androidContext
import org.koin.compose.KoinApplication

@ExperimentalComposeUiApi
@ExperimentalMaterialApi
@ExperimentalLayoutApi
@ExperimentalFoundationApi
@ExperimentalMaterial3Api
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            KoinApplication(application = {
                androidContext(applicationContext)
                modules(
                    dataUserModule
                )
            }) {

            }

            GlengarryTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    GlengarryNavHost()
                }
            }
        }
    }
}
