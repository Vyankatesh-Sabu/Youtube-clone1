package com.example.example

import kotlinx.serialization.Serializable
import kotlinx.serialization.SerialName


@Serializable
data class Items (

  @SerialName("kind"    ) var kind    : String?  = null,
  @SerialName("etag"    ) var etag    : String?  = null,
  @SerialName("id"      ) var id      : Id      = Id(),
  @SerialName("snippet" ) var snippet : Snippet = Snippet()

)