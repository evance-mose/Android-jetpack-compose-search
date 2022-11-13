package org.dtree.exercise.ui

import org.dtree.exercise.domain.model.UserModel

data class UserState(
    val data : List<UserModel> = emptyList()
)
