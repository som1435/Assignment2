package com.example.trendingprojects.view

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import com.example.trendingprojects.NavGraphs
import com.example.trendingprojects.TrendingProjectListingScreen
import com.example.trendingprojects.TrendingProjectScreen
import com.example.trendingprojects.destinations.TrendingProjectListingScreenDestination
import com.example.trendingprojects.destinations.TrendingProjectScreenDestination
import com.example.trendingprojects.viewmodel.TrendingProjectListingViewModel
import com.example.trendingprojects.viewmodel.TrendingProjectViewModel
import com.ramcosta.composedestinations.DestinationsNavHost
import com.ramcosta.composedestinations.manualcomposablecalls.composable
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class TrendingProjectActivity : ComponentActivity() {

    private val trendingProjectViewModel: TrendingProjectViewModel by viewModels()
    private val trendingProjectListingViewModel: TrendingProjectListingViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DestinationsNavHost(navGraph = NavGraphs.root) {
                composable(TrendingProjectScreenDestination) {
                    TrendingProjectScreen(
                        navigator = destinationsNavigator,
                        trendingProjectViewModel = trendingProjectViewModel
                    )
                }
                composable(TrendingProjectListingScreenDestination) {
                    TrendingProjectListingScreen(
                        navigator = destinationsNavigator,
                        trendingProjectListingViewModel = trendingProjectListingViewModel
                    )
                }
            }
        }
    }
}


//@Preview(showBackground = true)
//@Composable
//fun DefaultPreview() {
//    TrendingProjectsTheme {
//        Greeting("Android")
//    }
//}