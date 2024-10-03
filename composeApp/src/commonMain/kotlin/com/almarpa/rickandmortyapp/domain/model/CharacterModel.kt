package com.almarpa.rickandmortyapp.domain.model

import kotlinx.serialization.Serializable

@Serializable
data class CharacterModel(
    val id: Int,
    val isAlive: Boolean,
    val image: String,
    val name:String,
    val species:String,
    val gender:String,
    val origin:String,
    val episodes:List<String>
)