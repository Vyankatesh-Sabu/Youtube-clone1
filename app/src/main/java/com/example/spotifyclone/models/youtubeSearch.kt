package com.example.example

import kotlinx.serialization.Serializable
import kotlinx.serialization.SerialName


@Serializable
data class youtubeSearch (

  @SerialName("kind"          ) var kind          : String?          = null,
  @SerialName("etag"          ) var etag          : String?          = null,
  @SerialName("nextPageToken" ) var nextPageToken : String?          = null,
  @SerialName("regionCode"    ) var regionCode    : String?          = null,
  @SerialName("pageInfo"      ) var pageInfo      : PageInfo?        = PageInfo(),
  @SerialName("items"         ) var items         : ArrayList<Items> = arrayListOf()

)