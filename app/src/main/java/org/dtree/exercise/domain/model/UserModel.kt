package org.dtree.exercise.domain.model


data class UserModel(
    val id: String? = null,
    val name: String,
    val surname: String,
    val age: Int,
    val city: String,

)
