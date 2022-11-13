package org.dtree.exercise.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import org.dtree.exercise.Util
import org.dtree.exercise.data.local.entity.UserEntity
import org.dtree.exercise.data.repository.UserRepoImpl
import javax.inject.Inject

@HiltViewModel
class UserListViewModel @Inject constructor(
    repo: UserRepoImpl
) : ViewModel() {

    private var _state = MutableStateFlow(UserState())
    val state: StateFlow<UserState> = _state

    val searchQuery = MutableStateFlow("")

    private val flatMapLatest = searchQuery.flatMapLatest {
        repo.query(it)
    }


    init {
        flatMapLatest.onEach {
            _state.value = _state.value.copy(data = it.map { it.toUserModel() })
        }.launchIn(viewModelScope)
    }


}