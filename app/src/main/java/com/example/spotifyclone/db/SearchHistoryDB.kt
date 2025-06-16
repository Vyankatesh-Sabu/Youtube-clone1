package com.example.spotifyclone.db

import androidx.lifecycle.LiveData
import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.spotifyclone.db.model.searchHistory


@Database(entities = [searchHistory::class], version = 1)
@TypeConverters(Converters::class)
abstract class SearchHistoryDB : RoomDatabase() {

    companion object{
        const val DB_Name = "searchHistoryDB"
    }

    abstract fun getAllsearches() : SearchHistoryDao
}