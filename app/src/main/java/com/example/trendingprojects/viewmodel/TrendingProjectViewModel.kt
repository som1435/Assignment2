package com.example.trendingprojects.viewmodel

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.trendingprojects.data.Project
import com.example.trendingprojects.repository.ProjectRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import javax.inject.Inject

@HiltViewModel
class TrendingProjectViewModel @Inject constructor(
    val savedStateHandle: SavedStateHandle,
    private val projectRepository: ProjectRepository
) :
    ViewModel() {

    val projects: StateFlow<List<Project>> = flow {
        projectRepository.getShuffledProjects().collect { emit(it) }
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

}