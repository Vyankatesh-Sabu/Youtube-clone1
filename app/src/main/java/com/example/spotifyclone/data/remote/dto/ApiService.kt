package com.example.spotifyclone.data.remote.dto

import com.example.example.youtubeSearch

import io.ktor.client.HttpClient
import io.ktor.client.engine.android.Android
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json


interface ApiService {

    suspend fun getSearches(
        q : String,
        part : String,
        regionCode : String?,
        maxResults : Int?,
        order : String?,
        pageToken : String?
    ) : youtubeSearch

    companion object {
        fun create() : ApiService {
            return ApiServiceImplementation(
                client = HttpClient (Android){
                    install(ContentNegotiation){
                        json(Json)
                    }
                }
            )
        }
    }
}