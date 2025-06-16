package com.example.example

import kotlinx.serialization.Serializable
import kotlinx.serialization.SerialName


@Serializable
data class PageInfo (

  @SerialName("totalResults"   ) var totalResults   : Int? = null,
  @SerialName("resultsPerPage" ) var resultsPerPage : Int? = null

)