package com.javisoft.rabbiton

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.javisoft.rabbiton.navigation.AppNavigation
import com.javisoft.rabbiton.ui.theme.RabbitOnTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            RabbitOnTheme {
                RabbitOnApp()

            }
        }
    }
}

@Composable
fun RabbitOnApp() {
    val navController = rememberNavController()
    AppNavigation(navController)
}

@Preview(showBackground = true)
@Composable
fun AppPreview() {
    RabbitOnTheme {
        RabbitOnApp()
    }
}