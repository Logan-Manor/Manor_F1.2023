package com.example.manor_f12023.team

import androidx.lifecycle.viewModelScope
import com.example.manor_f12023.database.F1Repository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch


class TeamListViewModel {
    private val f1Repository = F1Repository.get()

    private val _teams: MutableStateFlow<List<Team>> = MutableStateFlow(emptyList())
    val teams: StateFlow<List<Team>>
        get() = _teams.asStateFlow()

    init {
        viewModelScope.launch {
            f1Repository.getTeams().collect {
                _teams.value = it
            }
        }
    }
}