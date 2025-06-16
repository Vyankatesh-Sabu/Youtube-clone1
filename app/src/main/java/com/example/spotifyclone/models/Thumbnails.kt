package com.example.example

import kotlinx.serialization.Serializable
import kotlinx.serialization.SerialName


@Serializable
data class Thumbnails (

  @SerialName("default" ) var default : Default? = Default(),
  @SerialName("medium"  ) var medium  : Medium?  = Medium(),
  @SerialName("high"    ) var high    : High    = High()

)