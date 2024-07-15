package com.example.composescreens.presentation.main

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.rememberNavController
import com.example.composescreens.presentation.navigation.ComposeScreensNavGraph
import com.example.composescreens.presentation.navigation.LocalNavigationProvider
import com.example.composescreens.presentation.theme.ComposeScreensTheme
import com.example.composescreens.presentation.theme.customColors
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeScreensTheme {
                val navController = rememberNavController()
                val systemUiController = rememberSystemUiController()
                val viewmodel: MainViewModel = hiltViewModel()
                val isFirstTimeLaunchComplete by viewmodel.isFirstTimeLaunchComplete.collectAsState()
                systemUiController.setSystemBarsColor(
                    darkIcons = false,
                    color = MaterialTheme.customColors.black,
                )
                CompositionLocalProvider(LocalNavigationProvider provides navController) {
                    Scaffold(modifier = Modifier.fillMaxSize()) {
                        ComposeScreensNavGraph(navController, isFirstTimeLaunchComplete)
                    }
                }
            }
        }
    }
}




