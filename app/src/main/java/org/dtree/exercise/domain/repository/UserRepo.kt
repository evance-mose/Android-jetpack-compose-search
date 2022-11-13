package org.dtree.exercise.domain.repository

import kotlinx.coroutines.flow.Flow
import org.dtree.exercise.data.local.entity.UserEntity

interface UserRepo {
    suspend fun insert(users: List<UserEntity>)
    fun query(query: String=""): Flow<List<UserEntity>>
}