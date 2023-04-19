package com.example.manor_f12023.team

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.example.manor_f12023.database.F1Repository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class TeamDetailViewModel(TeamRank: Int) : ViewModel(){
    private val f1Repository = F1Repository.get()

    private val _team: MutableStateFlow<Team?> = MutableStateFlow(null)
    val team: StateFlow<Team?> = _team.asStateFlow()

    init {
        viewModelScope.launch {
            _team.value = f1Repository.getTeam(TeamRank)
        }
    }
}

class TeamDetailViewModelFactory(
    private val TeamRank: Int
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return TeamDetailViewModel(TeamRank) as T
    }
}