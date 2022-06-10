package com.example.challenge.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.challenge.presentation.movie.NavGraphs
import com.example.challenge.presentation.movie.appCurrentDestinationAsState
import com.example.challenge.presentation.movie.destinations.Destination
import com.example.challenge.presentation.movie.startAppDestination
import com.example.challenge.presentation.ui.theme.ChallengeTheme
import com.example.challenge.presentation.ui.theme.blueNight
import com.example.challenge.utils.BottomBarDestination
import com.ramcosta.composedestinations.DestinationsNavHost
import com.ramcosta.composedestinations.navigation.navigate
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ChallengeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    val navController = rememberNavController()
                    Scaffold(
                        backgroundColor = blueNight,
                        bottomBar = { BottomBar(navController = navController) }
                    ) {
                        DestinationsNavHost(
                            navGraph = NavGraphs.root,
                            navController = navController,
                            modifier = Modifier.padding(it)
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun BottomBar(
    navController: NavController
) {
    val currentDestination: Destination? =
        navController.appCurrentDestinationAsState().value ?: NavGraphs.root.startAppDestination

    BottomNavigation {
        BottomBarDestination.values().forEach { destination ->
            BottomNavigationItem(
                selected = currentDestination == destination.direction,
                onClick = {
                    navController.navigate(destination.direction) {
                        launchSingleTop = true
                    }
                },
                icon = { Icon(destination.icon, contentDescription = destination.label) },
                label = { Text(text = destination.label) }
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ChallengeTheme {
        BottomBar(navController = rememberNavController())
    }
}