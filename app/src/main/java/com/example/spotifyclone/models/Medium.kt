package com.example.example

import kotlinx.serialization.Serializable
import kotlinx.serialization.SerialName


@Serializable
data class Medium (

  @SerialName("url"    ) var url    : String? = null,
  @SerialName("width"  ) var width  : Int?    = null,
  @SerialName("height" ) var height : Int?    = null

)