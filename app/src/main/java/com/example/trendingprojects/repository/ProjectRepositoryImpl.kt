package com.example.trendingprojects.repository

import com.example.trendingprojects.data.Project
import com.example.trendingprojects.data.ProjectDao
import com.example.trendingprojects.repository.ProjectRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class ProjectRepositoryImpl @Inject constructor(private val projectDao: ProjectDao) :
    ProjectRepository {
    override suspend fun getProjects(): Flow<List<Project>> = projectDao.getProjects()


    override suspend fun updateProject(id: Int, fav: Boolean) {
        projectDao.updateProject(id, fav)
    }

    override suspend fun getShuffledProjects(): Flow<List<Project>> =
        projectDao.getShuffledProjects()

}