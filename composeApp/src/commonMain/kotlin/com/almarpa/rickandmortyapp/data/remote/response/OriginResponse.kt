package com.almarpa.rickandmortyapp.data.remote.response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class OriginResponse(
    @SerialName("name")
    val name:String,
)