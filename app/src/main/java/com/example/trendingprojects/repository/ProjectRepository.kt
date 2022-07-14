package com.example.trendingprojects.repository

import com.example.trendingprojects.data.Project
import kotlinx.coroutines.flow.Flow

interface ProjectRepository {
    suspend fun getProjects(): Flow<List<Project>>
    suspend fun getShuffledProjects(): Flow<List<Project>>
    suspend fun updateProject(id: Int, fav: Boolean)
}