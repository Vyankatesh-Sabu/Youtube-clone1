package com.example.spotifyclone.db.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.sql.Date

@Entity
data class searchHistory(
    @PrimaryKey(true)
    val id : Long = 0,
    val title : String,
    val createdAt : Long
)
