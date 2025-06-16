package com.example.spotifyclone.data

import androidx.room.Query
import com.example.example.youtubeSearch
import com.example.spotifyclone.data.remote.dto.ApiService
import kotlin.math.max

class ApiServiceRepository(private val apiService: ApiService) {
    suspend fun getSearchResults(query: String) : youtubeSearch{
        return apiService.getSearches(
            q = query,
            part = "snippet,id",
            regionCode = null,
            maxResults = 50,
            order = null,
            pageToken = null
        )
    }
}