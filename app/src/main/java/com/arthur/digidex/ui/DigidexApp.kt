package com.arthur.digidex.ui

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.compose.rememberNavController
import com.arthur.digidex.ui.theme.DigidexTheme
import kotlinx.coroutines.ExperimentalCoroutinesApi

@ExperimentalAnimationApi
@ExperimentalCoroutinesApi
@ExperimentalMaterialApi
@Composable
fun DigidexApp() {
    DigidexTheme {
        val navController = rememberNavController()

        Scaffold {
            DigidexNavGraph(
                navController = navController
            )
        }

    }
}