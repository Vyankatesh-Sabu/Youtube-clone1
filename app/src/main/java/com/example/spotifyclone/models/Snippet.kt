package com.example.example

import kotlinx.serialization.Serializable
import kotlinx.serialization.SerialName


@Serializable
data class Snippet (

  @SerialName("publishedAt"          ) var publishedAt          : String?     = null,
  @SerialName("channelId"            ) var channelId            : String?     = null,
  @SerialName("title"                ) var title                : String?     = null,
  @SerialName("description"          ) var description          : String?     = null,
  @SerialName("thumbnails"           ) var thumbnails           : Thumbnails = Thumbnails(),
  @SerialName("channelTitle"         ) var channelTitle         : String?     = null,
  @SerialName("liveBroadcastContent" ) var liveBroadcastContent : String?     = null,
  @SerialName("publishTime"          ) var publishTime          : String?     = null

)