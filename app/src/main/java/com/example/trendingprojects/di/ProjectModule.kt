package com.example.trendingprojects

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.example.trendingprojects.data.Project
import com.example.trendingprojects.data.ProjectDao
import com.example.trendingprojects.data.ProjectDatabase
import com.example.trendingprojects.repository.ProjectRepository
import com.example.trendingprojects.repository.ProjectRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.launch
import javax.inject.Provider
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ProjectModule {
    @Provides
    @Singleton
    fun provideProjectDatabase(
        @ApplicationContext context: Context,
        provider: Provider<ProjectDao>
    ): ProjectDatabase =
        Room.databaseBuilder(context, ProjectDatabase::class.java, "project.db")
            .addCallback(ProjectCallback(provider))
            .build()

    @Provides
    @Singleton
    fun provideProjectDao(projectDatabase: ProjectDatabase): ProjectDao =
        projectDatabase.projectDao()

    @Provides
    @Singleton
    fun provideProjectRepositoryImpl(projectDao: ProjectDao): ProjectRepository =
        ProjectRepositoryImpl(projectDao)
}

class ProjectCallback(
    private val provider: Provider<ProjectDao>
) : RoomDatabase.Callback() {

    private val applicationScope = CoroutineScope(SupervisorJob())

    override fun onCreate(db: SupportSQLiteDatabase) {
        super.onCreate(db)
        applicationScope.launch(Dispatchers.IO) {
            populateDatabase()
        }
    }

    private suspend fun populateDatabase() {
        val p1 = Project(
            "Signature Global Park 4 And 5 Phase II",
            "ROOFNASSETS INFRA PVT LTD",
            "2, 3 BHK",
            "Sector 36 Sohna, Gurgaon",
            "₹ 56.25L - 61.58 L",
            false
        )
        val p2 = Project(
            "Assotech Blith",
            "Busy Street Consultancy PVT LTD",
            "2, 3, 4 BHK",
            "Sector 99, Dwarka Expressway",
            "₹ 88.73L - 1.84 Cr",
            false
        )

        for (i in 1..15) {
            if (i % 2 == 1) provider.get().insertProject(p1)
            else provider.get().insertProject(p2)
        }
    }
}