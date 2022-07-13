package com.example.trendingprojects

import androidx.compose.foundation.background
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import com.example.trendingprojects.data.Project
import com.example.trendingprojects.viewmodel.TrendingProjectListingViewModel
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator
import kotlinx.coroutines.flow.collect

@OptIn(ExperimentalMaterial3Api::class)
@Destination
@Composable
fun TrendingProjectListingScreen(
    navigator: DestinationsNavigator,
    trendingProjectListingViewModel: TrendingProjectListingViewModel
) {
    var projects: List<Project> by remember {
        mutableStateOf(emptyList())
    }

    LaunchedEffect(key1 = true)
    {
        trendingProjectListingViewModel.projects.collect { projectList ->
            projects = projectList
        }
    }

    Scaffold(
        topBar = {
            MediumTopAppBar(
                modifier = Modifier.background(Color(0XFFedebe6)),
                title = { Text(text = "Trending Projects", fontWeight = FontWeight.Bold) },
                navigationIcon =
                {
                    IconButton(onClick = { navigator.navigateUp() }) {
                        Icon(
//                            imageVector = Icons.Filled.ArrowBack,
                            imageVector = Icons.Filled.ArrowBack,
                            contentDescription = "Back"
                        )
                    }
                },
                colors = TopAppBarDefaults.mediumTopAppBarColors(containerColor = Color(0XFFcccac6))
            )
        },
        content = {
            // Body content
            LazyColumn(modifier = Modifier.background(Color(0XFFedebe6))) {
                items(items = projects) { project ->
                    ProjectVerticalCard(project, trendingProjectListingViewModel)
                }
            }
        },
    )
}