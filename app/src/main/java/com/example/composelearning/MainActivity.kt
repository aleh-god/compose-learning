package com.example.composelearning

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.composelearning.data.StaticDataSource
import com.example.composelearning.ui.navigation.AppDestinations
import com.example.composelearning.ui.screens.DerivedStateDemo
import com.example.composelearning.ui.screens.DisposableEffectDemo
import com.example.composelearning.ui.screens.LaunchedEffectDemo
import com.example.composelearning.ui.screens.MainScreen
import com.example.composelearning.ui.screens.ProduceStateDemo
import com.example.composelearning.ui.screens.RememberUpdatedStateDemo
import com.example.composelearning.ui.theme.ComposeLearningTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeLearningTheme {

                val navController = rememberNavController()


                Surface(
                    modifier = Modifier
                        .fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    NavHost(
                        navController = navController,
                        startDestination = AppDestinations.MAIN.label
                    ) {
                        composable(AppDestinations.MAIN.label) {
                            MainScreen(
                                onClickItem = {
                                    navController.navigate(it)
                                }
                            )
                        }
                        composable(AppDestinations.LAUNCHED.label) { LaunchedEffectDemo() }
                        composable(AppDestinations.DERIVED.label) { DerivedStateDemo() }
                        composable(AppDestinations.PRODUCE.label) {
                            ProduceStateDemo(
                                provideRepository = { StaticDataSource }
                            )
                        }
                        composable(AppDestinations.REMEMBER.label) { RememberUpdatedStateDemo() }
                        composable(AppDestinations.DISPOSABLE.label) { DisposableEffectDemo() }
                    }
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
    ComposeLearningTheme {
        Greeting("Android")
    }
}