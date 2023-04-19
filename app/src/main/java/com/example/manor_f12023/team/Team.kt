package com.example.manor_f12023.team

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Team")
data class Team(
    @PrimaryKey(autoGenerate = true)
    val rank: Integer?,
    val name: String?,
    val chief: String?,
    val driver1: String?,
    val driver2: String?,
    val championships: String?
)
