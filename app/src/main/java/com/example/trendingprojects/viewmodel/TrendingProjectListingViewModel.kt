package com.example.trendingprojects.viewmodel

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.trendingprojects.data.Project
import com.example.trendingprojects.repository.ProjectRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.*
import javax.inject.Inject

@HiltViewModel
class TrendingProjectListingViewModel @Inject constructor(
    val savedStateHandle: SavedStateHandle,
    private val projectRepository: ProjectRepository
) : ViewModel() {

    val projects: StateFlow<List<Project>> = flow {
        projectRepository.getProjects().collect { emit(it) }
    }.stateIn(
        scope = viewModelScope,
        started = SharingStarted.WhileSubscribed(),
        initialValue = emptyList()
    )

//    fun getProjects(): Flow<List<Project>> {
//        viewModelScope.async {
//            val res = projectRepository.getProjects()
//            awaitAll(res.)
//        }
//    }

    fun updateProject(id: Int, fav: Boolean) {
        viewModelScope.launch(Dispatchers.IO) {
            projectRepository.updateProject(id, fav)
        }
    }

}