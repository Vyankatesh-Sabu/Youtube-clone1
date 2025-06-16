package com.example.spotifyclone.data.remote.dto


import com.example.example.Items
import com.example.example.youtubeSearch
import com.example.spotifyclone.data.remote.HttpRoutes

import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.request.parameter
import io.ktor.client.request.url


class ApiServiceImplementation(
    private val client: HttpClient
) : ApiService {

    override suspend fun getSearches(
        q: String,
        part: String,
        regionCode: String?,
        maxResults: Int?,
        order: String?,
        pageToken: String?
    ): youtubeSearch {
            return try{
                client.get {
                    url(HttpRoutes.search)
                    parameter("q", q)
                    parameter("part", part)
                    parameter("maxResults", maxResults)
                    parameter("key", "AIzaSyD6u0MKAO1EZqq2KKKdzN7P0x6DsZjAtJw")
                }.body<youtubeSearch>()
            }catch (e : Exception){
                println("Error: something is foi ${e.message}")
                youtubeSearch(null, null, null, null, null, arrayListOf())
            }
    }
}

// API Key
//AIzaSyD6u0MKAO1EZqq2KKKdzN7P0x6DsZjAtJw