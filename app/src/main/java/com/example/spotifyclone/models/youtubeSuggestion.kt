package com.example.spotifyclone.models

import com.example.example.Items
import com.example.example.PageInfo
import kotlinx.serialization.Serializable

@Serializable
data class youtubeSuggestion(
    val items: List<Items>,
    val kind: String,
    val nextPageToken: String,
    val pageInfo: PageInfo
)