package com.example.example

import kotlinx.serialization.Serializable
import kotlinx.serialization.SerialName


@Serializable
data class Id (

  @SerialName("kind"       ) var kind       : String? = null,
  @SerialName("playlistId" ) var playlistId : String? = null,
  @SerialName("channelId")   var channelId : String? = null,
  @SerialName("videoId")     var videoId : String? = null
)