package com.example.trendingprojects.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.trendingprojects.data.Project
import kotlinx.coroutines.flow.Flow

@Dao
interface ProjectDao {
    @Insert
    fun insertProject(project: Project)

    @Query("UPDATE project SET isFavorite=:fav WHERE projectId=:id")
    fun updateProject(id: Int, fav: Boolean)

    @Query("SELECT * FROM project")
    fun getProjects(): Flow<List<Project>>

    @Query("SELECT * FROM project ORDER BY RANDOM() LIMIT 5")
    fun getShuffledProjects(): Flow<List<Project>>

}