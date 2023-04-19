package com.example.manor_f12023.database

import androidx.room.Dao
import androidx.room.Query
import com.example.manor_f12023.team.Team
import kotlinx.coroutines.flow.Flow

@Dao
interface F1Dao {


    @Query("SELECT * FROM Team")
    fun getTeams(): Flow<List<Team>>

    @Query("SELECT * FROM Team WHERE rank=(:id)")
    suspend fun getTeam(id: Int): Team
}