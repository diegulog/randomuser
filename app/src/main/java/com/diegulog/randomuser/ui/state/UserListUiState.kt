package com.diegulog.randomuser.ui.state

import com.diegulog.randomuser.domain.entity.User

data class UserListUiState(
    val isLoading: Boolean = false,
    val users: List<User> = emptyList(),
    val error: Throwable? = null
)