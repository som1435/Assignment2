package com.example.trendingprojects

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.trendingprojects.data.Project
import com.example.trendingprojects.destinations.TrendingProjectListingScreenDestination
import com.example.trendingprojects.ui.theme.Purple40
import com.example.trendingprojects.viewmodel.TrendingProjectViewModel
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.annotation.RootNavGraph
import com.ramcosta.composedestinations.navigation.DestinationsNavigator
import kotlinx.coroutines.flow.collect

@RootNavGraph(start = true)
@Destination
@Composable
fun TrendingProjectScreen(
    navigator: DestinationsNavigator,
    trendingProjectViewModel: TrendingProjectViewModel
//    trendingProjectViewModel: TrendingProjectViewModel = viewModel()
) {
    var projects: List<Project> by remember {
        mutableStateOf(emptyList())
    }

    LaunchedEffect(key1 = true)
    {
        trendingProjectViewModel.projects.collect { projectList ->
            projects = projectList
        }
    }


    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0XFFedebe6)),
        contentAlignment = Alignment.Center
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(all = 16.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = "Trending Projects",
                    fontWeight = FontWeight.Bold,
                    fontSize = 20.sp,
                    color = Color.Black
                )
                TextButton(
                    onClick = { navigator.navigate(TrendingProjectListingScreenDestination) }
                ) {
                    Text(text = "See All", color = Purple40, fontSize = 16.sp)
                }
            }
            Text(text = "Most seen projects by buyers in Gurgaon", color = Color.Gray)
            LazyRow() {
                items(items = projects) { project ->
                    ProjectHorizontalCard(project)
                }
            }
        }
    }
}