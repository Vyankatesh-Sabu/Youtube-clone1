package com.example.spotifyclone.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.spotifyclone.db.model.searchHistory

@Dao
interface SearchHistoryDao {

    @Query("SELECT * FROM searchHistory ORDER BY createdAt DESC")
    fun getSearchHistory() : LiveData<List<searchHistory>>

    @Insert
    fun addSearch(searchHistory: searchHistory)

    @Query("DELETE FROM searchHistory WHERE id = :id")
    fun deleteSearch(id : Long)
    
}