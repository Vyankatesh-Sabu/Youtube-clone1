package com.example.spotifyclone

import android.app.Application
import androidx.room.Room
import com.example.spotifyclone.data.ApiServiceRepository
import com.example.spotifyclone.data.remote.dto.ApiService
import com.example.spotifyclone.db.SearchHistoryDB

class MainApplication : Application() {
    companion object{
        lateinit var apiServiceRepository : ApiServiceRepository
        lateinit var searchHistoryDB: SearchHistoryDB
    }

    override fun onCreate() {
        super.onCreate()
        val apiService = ApiService.create()
        apiServiceRepository = ApiServiceRepository(apiService)
        searchHistoryDB = Room.databaseBuilder(
            applicationContext,
            SearchHistoryDB::class.java,
            SearchHistoryDB.DB_Name
        ).build()
    }

}