package com.example.trendingprojects.data

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.trendingprojects.data.Project
import com.example.trendingprojects.data.ProjectDao

@Database(entities = [Project::class], version = 1)
abstract class ProjectDatabase : RoomDatabase() {
    abstract fun projectDao(): ProjectDao
}