package com.example.manor_f12023.database

import android.content.Context
import androidx.room.Room
import com.example.manor_f12023.team.Team
import kotlinx.coroutines.flow.Flow

private const val DATABASE_NAME = "F1DB.db"

class F1Repository private constructor(context: Context){
    private val database: F1Database = Room.databaseBuilder(
        context.applicationContext,
        F1Database::class.java,
        DATABASE_NAME
    )
        .createFromAsset(DATABASE_NAME)
        .build()

    fun getTeams(): Flow<List<Team>> = database.F1Dao().getTeams()

    suspend fun getTeam(rank: Int): Team = database.F1Dao().getTeam(rank)

    companion object {
        private var INSTANCE: F1Repository? = null

        fun initialize(context: Context) {
            if (INSTANCE == null) {
                INSTANCE = F1Repository(context)
            }
        }

        fun get(): F1Repository {
            return INSTANCE
                ?: throw IllegalStateException("TeamRepository must be initialized")
        }
    }
}