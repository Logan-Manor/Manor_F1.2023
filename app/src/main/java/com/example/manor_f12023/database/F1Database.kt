package com.example.manor_f12023.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.manor_f12023.team.Team

@Database(entities = [Team::class], version = 1)
abstract class F1Database : RoomDatabase() {
    abstract fun F1Dao(): F1Dao
}